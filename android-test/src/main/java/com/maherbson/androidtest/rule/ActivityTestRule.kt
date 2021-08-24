package com.maherbson.androidtest.rule

import android.app.Activity
import android.app.Application
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.rules.ExternalResource
import org.junit.rules.RuleChain
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.Module

private const val PROPERTY_BASE_URL = "PROPERTY_BASE_URL"

open class ActivityTestRule<T : Activity>(
    private val mActivity: Class<out AppCompatActivity>,
    private val modules: List<Module>
) : TestRule {

    private lateinit var activityRule: ActivityScenario<T>

    private val mockWebServer = MockWebServer()

    override fun apply(base: Statement?, description: Description?): Statement {
        return RuleChain
            .outerRule(mockWebServer)
            .around(getKoinRule())
            .apply(base, description)
    }

    private fun getKoinRule(): KoinRule {
        val application =
            InstrumentationRegistry.getInstrumentation()
                .targetContext.applicationContext as Application
        val baseUrl = mockWebServer.url("/").toString()
        return KoinRule(application, baseUrl)
    }

    private inner class KoinRule(
        private val app: Application,
        private val baseUrl: String
    ) : ExternalResource() {

        override fun before() {
            super.before()
            stopKoin()
            startKoin {
                androidContext(app)
                modules(modules)
                properties(mapOf(PROPERTY_BASE_URL to baseUrl))
            }
            val intent = Intent().apply {
                component = ComponentName(app.applicationContext, mActivity)
                putExtras(Bundle())
            }
            activityRule = ActivityScenario.launch(intent)
        }

        override fun after() {
            super.after()
            activityRule.close()
            mockWebServer.shutdown()
            stopKoin()
        }
    }

    fun mockResponse(mockJson: String, code: Int) {
        val mockResponse = MockResponse().apply {
            setResponseCode(code)
            setBody(mockJson)
        }
        mockWebServer.enqueue(mockResponse)
    }
}
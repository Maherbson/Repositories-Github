package com.maherbson.androidtest.rule

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.maherbson.androidtest.robot.RobotAction
import com.maherbson.androidtest.robot.RobotArrangement
import com.maherbson.androidtest.robot.RobotAssertion
import org.junit.Before
import org.junit.Rule
import org.koin.core.module.Module
import org.koin.dsl.module

open class ActivityTest<out A : RobotAssertion, out B : RobotAction>(
    mActivity: Class<out AppCompatActivity>
) : RobotArrangement<A, B> {

    @get:Rule
    val activityTestRule = ActivityTestRule<Activity>(
        mActivity,
        this.getModules() + this.additionalModule()
    ) { declareMock() }

    open fun getModules(): List<Module> = emptyList()

    open fun additionalModule(): Module = module {}

    @Before
    open fun setUp() = Unit

    open fun declareMock() = Unit
}
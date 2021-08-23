package com.maherbson.androidtest.rule

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.maherbson.androidtest.robot.RobotAction
import com.maherbson.androidtest.robot.RobotArrangement
import com.maherbson.androidtest.robot.RobotAssertion
import org.junit.Rule
import org.koin.core.module.Module

abstract class ActivityTest<out A : RobotAssertion, out B : RobotAction>(
    activity: Class<out AppCompatActivity>
) : RobotArrangement<A, B> {

    @get:Rule
    val activityTestRule = ActivityTestRule<Activity>(activity, this.getModules())

    open fun getModules(): List<Module> = emptyList()

}
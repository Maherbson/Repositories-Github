package com.maherbson.androidtest.robot.extensions

import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.maherbson.androidtest.robot.RobotAction

fun <T : RecyclerView.ViewHolder> RobotAction.scrollBottom(position: Int, @IdRes resId: Int) {
    onView(withId(resId)).perform(scrollToPosition<T>(position))
}
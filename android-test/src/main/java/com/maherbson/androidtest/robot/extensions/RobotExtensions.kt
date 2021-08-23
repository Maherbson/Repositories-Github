package com.maherbson.androidtest.robot.extensions

import com.maherbson.androidtest.robot.RobotAction
import com.maherbson.androidtest.robot.RobotArrangement
import com.maherbson.androidtest.robot.RobotAssertion
import com.maherbson.androidtest.rule.ActivityTest
import java.net.HttpURLConnection

inline fun <reified R : RobotAssertion,
        reified A : RobotAction> RobotArrangement<R, A>.assertion(
    block: R.() -> Unit
): R = R::class.java.newInstance().apply(block)

inline fun <reified R : RobotAssertion,
        reified A : RobotAction> RobotArrangement<R, A>.action(
    block: A.() -> Unit
): A = A::class.java.newInstance().apply(block)

inline fun <reified R : RobotAction> ActivityTest<RobotAssertion, R>.mockJson(
    vararg fileJsonName: String,
    code: Int = HttpURLConnection.HTTP_OK
) {
    fileJsonName.forEach { fileJson ->
        val json = javaClass.classLoader?.getResource(fileJson)?.readText() ?: String()
        activityTestRule.mockResponse(json, code)
    }
}

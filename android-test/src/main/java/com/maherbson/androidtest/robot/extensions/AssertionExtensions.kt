import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.hasErrorText
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.maherbson.androidtest.robot.RobotAssertion
import org.hamcrest.CoreMatchers.not

fun RobotAssertion.checkIsDisplayed(@IdRes resId: Int) {
    onView(withId(resId)).check(matches(isDisplayed()))
}

fun RobotAssertion.checkTextIsDisplayed(text: String) {
    onView(withText(text)).check(matches(isDisplayed()))
}

fun RobotAssertion.checkExactTextExpected(resId: Int, expected: String) {
    onView(withId(resId)).check(matches(withText(expected)))
}

fun RobotAssertion.checkErrorText(@IdRes resId: Int, expected: String) {
    onView(withId(resId)).check(matches(hasErrorText(expected)))
}

fun RobotAssertion.checkIsNotDisplayed(@IdRes resId: Int) {
    onView(withId(resId))
        .check(matches(not(isDisplayed())))
}

fun RobotAssertion.checkIsEnabled(resId: Int) {
    onView(withId(resId)).check(matches(isEnabled()))
}

fun RobotAssertion.checkIsNotEnabled(resId: Int) {
    onView(withId(resId))
        .check(matches(not(isEnabled())))
}

fun RobotAssertion.checkIntent(intent: Intent) {
    Intents.intending(hasComponent(intent.component?.className))
        .respondWith(Instrumentation.ActivityResult(Activity.RESULT_CANCELED, null))
}

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.maherbson.androidtest.robot.RobotAssertion

fun RobotAssertion.checkTextIsDisplayed(text: String) {
    onView(withText(text)).check(matches(isDisplayed()))
}

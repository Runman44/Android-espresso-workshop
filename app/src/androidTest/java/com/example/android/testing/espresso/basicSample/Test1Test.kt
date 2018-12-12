package com.example.android.testing.espresso.basicSample

import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.android.testing.espresso.basicSample.robots.MainRobot
import com.example.android.testing.espresso.basicSample.robots.main
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class Test1Test {

    @get:Rule
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(
            MainActivity::class.java)

    @Test
    fun test1_newActivity_doubleText_error() {
        main {
            enterText("Espresso")
            clickTest1()
            hasText("Espresso")
        }
    }

    @Test
    fun test1_newActivity_doubleText_passed() {
        // Type text and then press the button.
        onView(withId(R.id.editTextUserInput)).perform(typeText("Espresso"),
                closeSoftKeyboard())
        onView(withId(R.id.test1)).perform(click())

        onView(withId(R.id.show_text_view_one)).check(matches(withText("Espresso")))
        onView(withId(R.id.show_text_view_two)).check(matches(withText("Espresso")))
    }
}
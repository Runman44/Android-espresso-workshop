package com.example.android.testing.espresso.basicSample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
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
        // Type text and then press the button.
        onView(withId(R.id.editTextUserInput)).perform(typeText("Espresso"),
                closeSoftKeyboard())
        onView(withId(R.id.test1)).perform(click())

        // Error on this line ! but why ?
        onView(withText("Espresso")).check(matches(isDisplayed()))
    }

    // TODO make it right !
    @Test
    fun test1_newActivity_doubleText_passed() {

    }
}
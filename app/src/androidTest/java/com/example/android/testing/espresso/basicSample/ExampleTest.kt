package com.example.android.testing.espresso.basicSample

import org.junit.Rule
import org.junit.Test

import androidx.test.rule.ActivityTestRule

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.runner.AndroidJUnit4
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleTest {

    private val espresso = "Espresso"

    @get:Rule
    var mActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun changeText_sameActivity() {
        // Type text and then press the button.
        onView(withId(R.id.editTextUserInput))
                .perform(typeText(espresso), closeSoftKeyboard())
        onView(withId(R.id.buttonChangeText)).perform(click())

        // Check that the text was changed.
        onView(withId(R.id.textToBeChanged)).check(matches(withText(espresso)))
    }

    @Test
    fun changeText_newActivity() {
        // Type text and then press the button.
        onView(withId(R.id.editTextUserInput)).perform(typeText(espresso),
                closeSoftKeyboard())
        onView(withId(R.id.buttonNewActivity)).perform(click())

        // This view is in a different Activity, no need to tell Espresso.
        onView(withId(R.id.showTextView)).check(matches(withText(espresso)))
    }
}
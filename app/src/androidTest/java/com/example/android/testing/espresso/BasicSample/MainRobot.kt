package com.example.android.testing.espresso.basicSample

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers

class MainRobot {

    fun enterText(text : String) : MainRobot {
        Espresso.onView(ViewMatchers.withId(R.id.editTextUserInput)).perform(ViewActions.typeText(text),
                ViewActions.closeSoftKeyboard())
        return this
    }

    fun clickTest1() : MainRobot {
        Espresso.onView(ViewMatchers.withId(R.id.test1)).perform(ViewActions.click())
        return this
    }

    fun hasText(text : String) : MainRobot {
        Espresso.onView(ViewMatchers.withText(text)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        return this
    }
}
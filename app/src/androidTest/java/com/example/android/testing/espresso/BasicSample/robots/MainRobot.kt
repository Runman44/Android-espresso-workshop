package com.example.android.testing.espresso.basicSample.robots

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.example.android.testing.espresso.basicSample.R

fun main(func: MainRobot.() -> Unit) = MainRobot().apply { func() }

class MainRobot {

    fun enterText(text : String) =
            onView(ViewMatchers.withId(R.id.editTextUserInput)).perform(ViewActions.typeText(text),
                    ViewActions.closeSoftKeyboard())

    fun clickTest1() = onView(ViewMatchers.withId(R.id.test1)).perform(ViewActions.click())

    fun hasText(text : String) = onView(ViewMatchers.withText(text)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

}

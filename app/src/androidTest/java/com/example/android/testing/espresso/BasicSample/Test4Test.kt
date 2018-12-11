package com.example.android.testing.espresso.basicSample

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.net.Uri
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class Test4Test {

    @get:Rule
    var intentRule: IntentsTestRule<MainActivity> = IntentsTestRule(MainActivity::class.java)

    @Test
    fun test4_intent_test() {
        val resultData = Intent()
        resultData.data = Uri.parse("something")
        val result = Instrumentation.ActivityResult(Activity.RESULT_OK, resultData)
        
        intending(hasAction(Intent.ACTION_PICK)).respondWith(result)

        onView(withId(R.id.test4)).perform(click())

        onView(withId(R.id.textToBeChanged)).check(matches(withText("something")))
    }
}
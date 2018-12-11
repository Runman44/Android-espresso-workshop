package com.example.android.testing.espresso.basicSample

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.android.testing.espresso.basicSample.test2.Test2ListAdapter
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class Test3Test {

    @get:Rule
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(
            MainActivity::class.java)

    @Test
    fun test3_newActivity_list_error() {
        // Type text and then press the button.
        onView(withId(R.id.editTextUserInput)).perform(typeText("Espresso"),
                closeSoftKeyboard())
        onView(withId(R.id.test3)).perform(click())

        // Error on this line ! but why ?
        onView(withText("Espresso 49")).check(matches(isDisplayed()))
    }

    @Test
    fun test3_newActivity_list_passed() {
        // Type text and then press the button.
        onView(withId(R.id.editTextUserInput)).perform(typeText("Espresso"), closeSoftKeyboard())
        onView(withId(R.id.test3)).perform(click())
        onView(withId(R.id.test2_list)).perform(RecyclerViewActions.scrollToHolder(withHolderTimeView("Espresso 49")))
    }

    private fun withHolderTimeView(text: String): Matcher<RecyclerView.ViewHolder> {
        return object : BoundedMatcher<RecyclerView.ViewHolder, Test2ListAdapter.ViewHolder>(Test2ListAdapter.ViewHolder::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("No ViewHolder found with text: $text")
            }

            override fun matchesSafely(item: Test2ListAdapter.ViewHolder): Boolean {
                val timeViewText = item.itemView.findViewById(R.id.test2_text) as TextView
                return timeViewText.text.toString().contains(text)
            }
        }
    }
}
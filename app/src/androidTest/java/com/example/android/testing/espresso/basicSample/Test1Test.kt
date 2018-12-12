package com.example.android.testing.espresso.basicSample

import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.android.testing.espresso.basicSample.robots.MainRobot
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
        MainRobot()
                .enterText("Espresso")
                .clickTest1()
                .hasText("Espresso")
    }

    // TODO make it right !
    @Test
    fun test1_newActivity_doubleText_passed() {

    }
}
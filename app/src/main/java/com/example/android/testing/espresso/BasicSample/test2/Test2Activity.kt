package com.example.android.testing.espresso.basicSample.test2

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

import com.example.android.testing.espresso.basicSample.R


/**
 * A simple [Activity] that shows a message.
 */
class Test2Activity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
    }

    companion object {

        const val KEY_EXTRA_MESSAGE = "com.example.android.testing.espresso.basicsample.MESSAGE"

        fun newStartIntent(context: Context, message: String): Intent {
            val newIntent = Intent(context, Test2Activity::class.java)
            newIntent.putExtra(KEY_EXTRA_MESSAGE, message)
            return newIntent
        }
    }
}

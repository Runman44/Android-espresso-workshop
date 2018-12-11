package com.example.android.testing.espresso.basicSample.test1

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

import com.example.android.testing.espresso.basicSample.R
import kotlinx.android.synthetic.main.activity_double_text.*

/**
 * A simple [Activity] that shows a message.
 */
class Test1Activity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_double_text)

        show_text_view_one.text = intent.getStringExtra(KEY_EXTRA_MESSAGE)
        show_text_view_two.text = intent.getStringExtra(KEY_EXTRA_MESSAGE)
    }

    companion object {

        const val KEY_EXTRA_MESSAGE = "com.example.android.testing.espresso.basicsample.MESSAGE"

        fun newStartIntent(context: Context, message: String): Intent {
            val newIntent = Intent(context, Test1Activity::class.java)
            newIntent.putExtra(KEY_EXTRA_MESSAGE, message)
            return newIntent
        }
    }
}

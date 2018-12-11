package com.example.android.testing.espresso.basicSample

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show_text.*

/**
 * A simple [Activity] that shows a message.
 */
class ShowTextActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_text)

        showTextView.text = intent.getStringExtra(KEY_EXTRA_MESSAGE)
    }

    companion object {

       const val KEY_EXTRA_MESSAGE = "com.example.android.testing.espresso.basicsample.MESSAGE"

        internal fun newStartIntent(context: Context, message: String): Intent {
            val newIntent = Intent(context, ShowTextActivity::class.java)
            newIntent.putExtra(KEY_EXTRA_MESSAGE, message)
            return newIntent
        }
    }
}

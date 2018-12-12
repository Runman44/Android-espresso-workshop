package com.example.android.testing.espresso.basicSample.test3

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.android.testing.espresso.basicSample.R
import kotlinx.android.synthetic.main.activity_list_3.*


/**
 * A simple [Activity] that shows a message.
 */
class Test3Activity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_3)

        // Get the message from the Intent.
        val message = intent.getStringExtra(KEY_EXTRA_MESSAGE)

        //Fill List
        val strings = arrayListOf<String>()
        for (i in 1 until 50) {
            strings.add("$message $i")
        }

        // Show List
        test3_list.layoutManager = LinearLayoutManager(this)
        test3_list.adapter = Test3Adapter(strings)
    }

    companion object {

        const val KEY_EXTRA_MESSAGE = "com.example.android.testing.espresso.basicsample.MESSAGE"

        fun newStartIntent(context: Context, message: String): Intent {
            val newIntent = Intent(context, Test3Activity::class.java)
            newIntent.putExtra(KEY_EXTRA_MESSAGE, message)
            return newIntent
        }
    }
}

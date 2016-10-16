package com.example.android.testing.espresso.BasicSample.test2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.testing.espresso.BasicSample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Activity} that shows a message.
 */
public class Test2Activity extends Activity {

    public final static String KEY_EXTRA_MESSAGE =
            "com.example.android.testing.espresso.basicsample.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Get the message from the Intent.
        Intent intent = getIntent();
        String message = intent.getStringExtra(KEY_EXTRA_MESSAGE);

        //Fill List
        List strings = new ArrayList();
        strings.add(message);
        strings.add(message);

        // Show List
        Test2ListAdapter adapter = new Test2ListAdapter(strings);

        RecyclerView list = (RecyclerView) findViewById(R.id.test2_list);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);
    }

    /**
     * Creates an {@link Intent} for {@link Test2Activity} with the message to be displayed.
     *
     * @param context the {@link Context} where the {@link Intent} will be used
     * @param message a {@link String} with text to be displayed
     * @return an {@link Intent} used to start {@link Test2Activity}
     */
    public static Intent newStartIntent(Context context, String message) {
        Intent newIntent = new Intent(context, Test2Activity.class);
        newIntent.putExtra(KEY_EXTRA_MESSAGE, message);
        return newIntent;
    }
}

package com.example.android.testing.espresso.BasicSample.test2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.testing.espresso.BasicSample.R;

import java.util.List;

public class Test2ListAdapter extends RecyclerView.Adapter<Test2ListAdapter.ViewHolder> {

    private final List<String> items;

    Test2ListAdapter(List<String> items) {
        this.items = items;
    }

    @Override
    public Test2ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, null);

        // create ViewHolder
        return new Test2ListAdapter.ViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(Test2ListAdapter.ViewHolder holder, int position) {
        holder.vTitle.setText(items.get(position));
    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView vTitle;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            vTitle = (TextView) itemLayoutView.findViewById(R.id.test2_text);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

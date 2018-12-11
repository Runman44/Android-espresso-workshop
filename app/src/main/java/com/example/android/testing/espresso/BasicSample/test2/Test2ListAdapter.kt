package com.example.android.testing.espresso.basicSample.test2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.android.testing.espresso.basicSample.R

class Test2ListAdapter (private val items: List<String>) : RecyclerView.Adapter<Test2ListAdapter.ViewHolder>() {

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Test2ListAdapter.ViewHolder {
        val itemLayoutView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, null)

        // create ViewHolder
        return Test2ListAdapter.ViewHolder(itemLayoutView)
    }

    override fun onBindViewHolder(holder: Test2ListAdapter.ViewHolder, position: Int) {
        holder.vTitle.text = items[position]
    }

    // inner class to hold a reference to each item of RecyclerView
    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        var vTitle = itemLayoutView.findViewById<View>(R.id.test2_text) as TextView
    }
}

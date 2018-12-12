package com.example.android.testing.espresso.basicSample.test3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.testing.espresso.basicSample.R

class Test3Adapter(private val items: List<String>) : RecyclerView.Adapter<Test3Adapter.ViewHolder>() {

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Test3Adapter.ViewHolder {
        val itemLayoutView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, null)
        return Test3Adapter.ViewHolder(itemLayoutView)
    }

    override fun onBindViewHolder(holder: Test3Adapter.ViewHolder, position: Int) {
        holder.vTitle.text = items[position]
    }


    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        var vTitle = itemLayoutView.findViewById<View>(R.id.test2_text) as TextView
    }
}
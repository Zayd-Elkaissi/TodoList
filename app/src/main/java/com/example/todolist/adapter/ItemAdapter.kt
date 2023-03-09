package com.example.todolist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R

class ItemAdapter(
    private val context: Context,
    private val dataset: MutableList<String>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val editButton: Button = view.findViewById(R.id.btnEdit)
        val deleteButton: Button = view.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = item.toString()

        holder.deleteButton.setOnClickListener {
            dataset.removeAt(position)
            this.notifyItemRemoved(position)
            Toast.makeText(context, "Task Deleted", Toast.LENGTH_SHORT).show()
        }
    }
    override fun getItemCount() = dataset.size
}
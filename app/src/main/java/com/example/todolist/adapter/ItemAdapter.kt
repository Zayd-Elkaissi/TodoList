package com.example.todolist.adapter

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.adapter.data.dataset

class ItemAdapter(private val context: Context,
                  private val datasource: dataset)
    : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val editButton: Button = view.findViewById(R.id.btnEdit)
        val deleteButton: Button = view.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    @SuppressLint("MissingInflatedId")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val task = datasource.tasks[position]
        holder.textView.text = task.title

        holder.deleteButton.setOnClickListener {
            datasource.tasks.removeAt(position)
            this.notifyItemRemoved(position)
            Toast.makeText(context, "Task Deleted", Toast.LENGTH_SHORT).show()
        }

        holder.editButton.setOnClickListener {
            val dialog = Dialog(context)
            val view: View = LayoutInflater.from(context).inflate(R.layout.edit_task, null)

            val updateButton: Button = view.findViewById(R.id.edit_task_button)
            val titleInput: EditText = view.findViewById(R.id.edit_task_title)

            titleInput.setText(task.title)

            updateButton.setOnClickListener {
                task.title = titleInput.text.toString()
                this.notifyItemChanged(position)
                dialog.cancel()
                Toast.makeText(context, "Task Updated", Toast.LENGTH_SHORT).show()
            }

            dialog.setContentView(view)
            dialog.show()
        }
    }

    override fun getItemCount(): Int = datasource.tasks.size
}
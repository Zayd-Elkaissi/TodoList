package com.example.todolist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.adapter.ItemAdapter
import com.example.todolist.adapter.data.dataset

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datasource: dataset = dataset()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, datasource)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val createButton: Button = findViewById(R.id.buttonAdd)
        createButton.setOnClickListener{
            val taskTitle: String = findViewById<EditText>(R.id.input).text.toString()
            datasource.add(taskTitle)
            Toast.makeText(this, "Task Added", Toast.LENGTH_SHORT).show()
            recyclerView.adapter?.notifyDataSetChanged()
        }

    }

}
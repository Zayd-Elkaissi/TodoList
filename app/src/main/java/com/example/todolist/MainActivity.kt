package com.example.todolist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.adapter.ItemAdapter

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myDataset = mutableListOf<String>()

        val input :EditText = findViewById(R.id.input)
        val btnAdd :Button = findViewById(R.id.buttonAdd)
       // val btnDelete:Button = findViewById(R.id.btnDelete)

        btnAdd.setOnClickListener{
            val value = input.text
            myDataset.add(value.toString())
            val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
            recyclerView.adapter = ItemAdapter(this, myDataset)

            input.setText("")
        }
    }
}
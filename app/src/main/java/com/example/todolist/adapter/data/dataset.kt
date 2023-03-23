package com.example.todolist.adapter.data

import com.example.todolist.adapter.model.Task


class dataset {
    val tasks = mutableListOf<Task>()

    fun add(title: String) {
        val task = Task(title)
        this.tasks.add(task)
    }

    fun delete(index: Int) {
        this.tasks.removeAt(index)
    }
}
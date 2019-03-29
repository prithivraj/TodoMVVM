package com.zestworks.todomvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(private val data: List<String>) : RecyclerView.Adapter<TodoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_list_item, parent, false)
        return TodoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.todoText.text = data[position]
    }

}

class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val todoText: TextView = itemView.findViewById(R.id.todo)
}

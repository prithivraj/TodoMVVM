package com.zestworks.todomvvm


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.zestworks.addtask.*
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment() {

    private lateinit var tasksViewModel: TasksViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onStart() {
        super.onStart()
        tasksViewModel = ViewModelProviders.of(activity!!).get(TasksViewModel::class.java)
        tasklist_recyclerview.layoutManager = LinearLayoutManager(context)
        tasksViewModel.viewState.observe(this, renderer)

        tasklist_add.setOnClickListener {
            Navigation.findNavController(view!!).navigate(R.id.action_listFragment_to_addFragment)
        }

    }

    private val renderer = Observer<ViewState> {
        tasklist_recyclerview.adapter = TodoAdapter(it.todoList)
        tasklist_recyclerview.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        (tasklist_recyclerview.adapter as TodoAdapter).notifyDataSetChanged()
    }
}

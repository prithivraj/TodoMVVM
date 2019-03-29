package com.zestworks.addtask


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_add.*
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService




class AddFragment : Fragment() {

    private lateinit var tasksViewModel: TasksViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onStart() {
        super.onStart()
        tasksViewModel = ViewModelProviders.of(activity!!).get(TasksViewModel::class.java)

        todo_submit.setOnClickListener {
            tasksViewModel.processEvent(
                SaveTodo(
                    text = todo_text.text.toString()
                )
            )
        }

        todo_text.requestFocus()
        val imm = context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0)

        tasksViewModel.viewEffects.observe(this, effectsRenderer)
    }

    private val effectsRenderer = Observer<ViewEffect> {

        return@Observer when (it) {
            Idle -> {
                //Do Nothing
            }
            NavigateUp -> {
                todo_text.onEditorAction(EditorInfo.IME_ACTION_DONE)
                todo_text.clearFocus()
                Navigation.findNavController(view!!).navigateUp()
                tasksViewModel.processEvent(ViewEffectCompleted)
            }
        }
    }
}

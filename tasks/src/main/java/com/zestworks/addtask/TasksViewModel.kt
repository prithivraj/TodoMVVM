package com.zestworks.addtask

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class TasksViewModel : ViewModel() {

    var viewState = MutableLiveData<ViewState>()

    var viewEffects = MutableLiveData<ViewEffect>()

    fun processEvent(viewEvent: ViewEvent){
        return when(viewEvent){
            is SaveTodo -> {
                var currentState = viewState.value
                if(currentState == null){
                    currentState = ViewState()
                }
                val todoList = currentState.todoList.toMutableList()
                todoList.add(viewEvent.text)
                viewState.postValue(
                    currentState.copy(
                        todoList = todoList
                    )
                )
                viewEffects.postValue(NavigateUp)
            }

            ViewEffectCompleted -> {
                viewEffects.postValue(Idle)
            }
        }
    }
}
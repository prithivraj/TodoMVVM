package com.zestworks.addtask


sealed class ViewEvent

data class SaveTodo(
    val text: String = ""
) : ViewEvent()

object ViewEffectCompleted: ViewEvent()
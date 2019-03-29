package com.zestworks.addtask


sealed class ViewEffect

object Idle : ViewEffect()
object NavigateUp : ViewEffect()
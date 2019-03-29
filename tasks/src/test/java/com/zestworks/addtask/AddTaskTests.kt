package com.zestworks.addtask

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class AddTaskTests {

    private lateinit var tasksViewModel: TasksViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        tasksViewModel = TasksViewModel()

    }

    @Test
    fun `Adding a task adds and dismisses the screen`() {
        val someText = listOf("Hello there")
        tasksViewModel.processEvent(SaveTodo(someText.first()))
        tasksViewModel.viewState.value shouldBe someText
        tasksViewModel.viewEffects.value shouldBe NavigateUp
    }

    @Test
    fun `View Effects resets correctly on completion`() {
        tasksViewModel.processEvent(ViewEffectCompleted)
        tasksViewModel.viewEffects.value shouldBe Idle
    }
}
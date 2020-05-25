package com.dean.composeplayground.model

data class MainScreenState(
    val title: String,
    val categories: List<Category>,
    val isLoading: Boolean
) {
    companion object {
        val EMPTY = MainScreenState("", emptyList(), false)
    }
}
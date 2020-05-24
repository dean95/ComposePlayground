package com.dean.composeplayground.main.views

import androidx.compose.Composable
import androidx.compose.mutableStateOf
import androidx.ui.foundation.AdapterList
import com.dean.composeplayground.main.model.Category

@Composable
fun CategoryList(categories: List<Category>) {
    AdapterList(data = categories) {
        val state = mutableStateOf(it)
        CategoryView(categoryState = state)
    }
}
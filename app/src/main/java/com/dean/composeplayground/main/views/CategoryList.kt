package com.dean.composeplayground.main.views

import androidx.compose.Composable
import androidx.compose.mutableStateOf
import androidx.ui.foundation.AdapterList
import com.dean.composeplayground.main.MainViewModel
import com.dean.composeplayground.model.Category

@Composable
fun CategoryList(categories: List<Category>, viewModel: MainViewModel) {
    AdapterList(data = categories) {
        val state = mutableStateOf(it)
        CategoryView(categoryState = state, viewModel = viewModel)
    }
}
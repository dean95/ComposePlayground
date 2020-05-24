package com.dean.composeplayground.main.views

import androidx.compose.Composable
import androidx.compose.getValue
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.livedata.observeAsState
import androidx.ui.material.CircularProgressIndicator
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.dean.composeplayground.main.MainViewModel
import com.dean.composeplayground.main.model.MainScreenState

@Composable
fun MainScreen(viewModel: MainViewModel) {

    val mainScreenState by viewModel.mainScreenState.observeAsState(initial = MainScreenState.EMPTY)

    if (mainScreenState.isLoading) {
        LoadingHomeScreen()
    } else {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            ScreenTitle(title = mainScreenState.title)
            Spacer(modifier = Modifier.preferredHeight(16.dp))
            CategorySearchView(viewModel)
            Spacer(modifier = Modifier.preferredHeight(8.dp))
            CategoryList(categories = mainScreenState.categories)
        }
    }
}

@Composable
private fun LoadingHomeScreen() {
    Box(modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center)) {
        CircularProgressIndicator()
    }
}

@Composable
fun ScreenTitle(title: String) {
    Text(
        text = title,
        style = TextStyle(
            color = Color.Black,
            fontSize = 48.sp
        )
    )
}
package com.dean.composeplayground.views

import androidx.compose.Composable
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.material.IconButton
import androidx.ui.material.TopAppBar
import androidx.ui.res.vectorResource
import com.dean.composeplayground.R

@Composable
fun EmailAppBar(onNavigationClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = "DeanMail")
        },
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(asset = vectorResource(id = R.drawable.ic_baseline_dehaze_24))
            }
        }
    )
}
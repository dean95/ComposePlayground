package com.dean.composeplayground.views

import androidx.compose.Composable
import androidx.ui.foundation.Icon
import androidx.ui.material.FloatingActionButton
import androidx.ui.res.vectorResource
import com.dean.composeplayground.R

@Composable
fun NewEmailButton(onClick: () -> Unit = {}) {
    FloatingActionButton(onClick = onClick) {
        Icon(asset = vectorResource(id = R.drawable.ic_baseline_add_24))
    }
}
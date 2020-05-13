package com.dean.composeplayground.views

import androidx.compose.Composable
import androidx.compose.mutableStateOf
import androidx.ui.foundation.AdapterList
import com.dean.composeplayground.model.Email

@Composable
fun EmailList(emails: List<Email>) {
    AdapterList(data = emails) { email ->
        val state = mutableStateOf(email)
        EmailView(emailState = state)
    }
}
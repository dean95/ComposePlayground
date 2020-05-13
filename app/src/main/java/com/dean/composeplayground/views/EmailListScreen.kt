package com.dean.composeplayground.views

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.material.Scaffold
import androidx.ui.material.ScaffoldState
import com.dean.composeplayground.model.Email
import com.dean.composeplayground.model.EmailNavigationItem

@Composable
fun EmailListScreen(
    emails: List<Email>,
    navItems: List<EmailNavigationItem>
) {
    val (state, onStateChanged) = state {
        ScaffoldState()
    }

    Scaffold(
        scaffoldState = state,
        topAppBar = {
            EmailAppBar { }
        },
        drawerContent = {
            EmailNavigation(navItems = navItems)
        },
        floatingActionButton = {
            NewEmailButton()
        }
    ) {
        EmailList(emails = emails)
    }
}
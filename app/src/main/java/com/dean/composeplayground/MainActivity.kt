package com.dean.composeplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.mutableStateOf
import androidx.ui.core.setContent
import com.dean.composeplayground.model.*
import com.dean.composeplayground.views.EmailList
import com.dean.composeplayground.views.EmailListScreen
import com.dean.composeplayground.views.EmailView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmailListScreen(emails = generateDummyEmails(), navItems = generateNavItems())
        }
    }

    private fun generateDummyEmails(): List<Email> {
        val emails = mutableListOf<Email>()
        repeat(100) {
            emails.add(
                Email(
                    "Dean Djermanovic",
                    true,
                    "Mar 5, 2020",
                    "Subject",
                    "Body text",
                    true
                )
            )
        }
        return emails
    }

    private fun generateNavItems(): List<EmailNavigationItem> {
        return listOf(
            AppNameItem,
            DividerItem,
            NavigationDestinationItem("All inboxes", R.drawable.ic_baseline_star_24, 0, {}),
            DividerItem,
            NavigationDestinationItem("Inbox", R.drawable.ic_baseline_star_24, 2, {}),
            SectionLabelItem("ALL LABELS"),
            NavigationDestinationItem("Starred", R.drawable.ic_baseline_star_24, 0, {}),
            NavigationDestinationItem("Starred", R.drawable.ic_baseline_star_24, 0, {}),
            NavigationDestinationItem("Starred", R.drawable.ic_baseline_star_24, 0, {}),
            NavigationDestinationItem("Starred", R.drawable.ic_baseline_star_24, 0, {}),
            NavigationDestinationItem("Starred", R.drawable.ic_baseline_star_24, 0, {}),
            NavigationDestinationItem("Starred", R.drawable.ic_baseline_star_24, 0, {}),
            NavigationDestinationItem("Starred", R.drawable.ic_baseline_star_24, 0, {}),
            NavigationDestinationItem("Starred", R.drawable.ic_baseline_star_24, 0, {}),
            NavigationDestinationItem("Starred", R.drawable.ic_baseline_star_24, 0, {}),
            NavigationDestinationItem("Starred", R.drawable.ic_baseline_star_24, 0, {}),
            NavigationDestinationItem("Starred", R.drawable.ic_baseline_star_24, 0, {}),
            NavigationDestinationItem("Starred", R.drawable.ic_baseline_star_24, 0, {}),
            NavigationDestinationItem("Starred", R.drawable.ic_baseline_star_24, 0, {}),
            NavigationDestinationItem("Starred", R.drawable.ic_baseline_star_24, 0, {}),
            NavigationDestinationItem("Starred", R.drawable.ic_baseline_star_24, 0, {}),
            NavigationDestinationItem("Starred", R.drawable.ic_baseline_star_24, 0, {}),
            NavigationDestinationItem("Starred", R.drawable.ic_baseline_star_24, 0, {}),
            NavigationDestinationItem("Starred", R.drawable.ic_baseline_star_24, 0, {}),
            NavigationDestinationItem("Starred", R.drawable.ic_baseline_star_24, 0, {}),
            NavigationDestinationItem("Starred", R.drawable.ic_baseline_star_24, 0, {}),
            NavigationDestinationItem("Starred", R.drawable.ic_baseline_star_24, 0, {})
        )
    }
}
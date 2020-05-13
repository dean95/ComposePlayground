package com.dean.composeplayground.views

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.Row
import androidx.ui.layout.Spacer
import androidx.ui.layout.padding
import androidx.ui.material.Divider
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.dean.composeplayground.exhaustive
import com.dean.composeplayground.model.*

@Composable
fun EmailNavigation(navItems: List<EmailNavigationItem>) {
    AdapterList(data = navItems) {
        when (it) {
            is AppNameItem -> AppNameItemView()
            is DividerItem -> DividerItemView()
            is SectionLabelItem -> SectionLabelItemView(label = it.label)
            is NavigationDestinationItem -> NavigationDestinationItemView(
                icon = it.icon,
                name = it.name,
                count = it.count,
                onClick = it.onClick
            )
        }.exhaustive
    }
}

@Composable
fun AppNameItemView() {
    Text(
        text = "DeanMail",
        modifier = Modifier.padding(8.dp),
        style = TextStyle(
            color = Color.Black,
            fontSize = 18.sp
        )
    )
}

@Composable
fun DividerItemView() {
    Divider(
        color = Color.Black
    )
}

@Composable
fun SectionLabelItemView(label: String) {
    Text(
        text = label,
        modifier = Modifier.padding(8.dp),
        style = TextStyle(
            color = Color.Gray,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
    )
}

@Composable
fun NavigationDestinationItemView(icon: Int, name: String, count: Int, onClick: () -> Unit) {
    Clickable(onClick = onClick) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalGravity = Alignment.CenterVertically
        ) {
            Icon(
                asset = vectorResource(id = icon),
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(text = name)
            Spacer(modifier = Modifier.weight(1f))
            if (count > 0) {
                Text(
                    text = count.toString(),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}
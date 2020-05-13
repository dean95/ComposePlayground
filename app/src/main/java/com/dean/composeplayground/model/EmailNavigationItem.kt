package com.dean.composeplayground.model

sealed class EmailNavigationItem
object AppNameItem : EmailNavigationItem()
object DividerItem : EmailNavigationItem()
data class SectionLabelItem(val label: String) : EmailNavigationItem()
data class NavigationDestinationItem(
    val name: String,
    val icon: Int,
    val count: Int,
    val onClick: () -> Unit
) : EmailNavigationItem()
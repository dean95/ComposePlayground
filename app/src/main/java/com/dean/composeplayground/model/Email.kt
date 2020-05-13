package com.dean.composeplayground.model

data class Email(
    val sender: String,
    val important: Boolean,
    val receiptTime: String,
    val subject: String,
    val body: String,
    val starred: Boolean
)
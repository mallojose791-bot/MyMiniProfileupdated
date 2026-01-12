package com.example.myminiprofile

data class NotificationItem(
    val senderName: String,
    val message: String,
    val time: String,
    val isRead: Boolean = false
)
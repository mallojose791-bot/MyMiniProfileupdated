package com.example.myminiprofile

data class ProfileItem(
    val title: String,
    val isHeader: Boolean = false,
    val isLogout: Boolean = false  // Add this parameter
)
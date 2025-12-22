package com.example.myminiprofile

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.myminiprofile)
        setupClicks()
        }
    fun setupClicks() {
        click(R.id.personalInfo, "Personal Information")
        click(R.id.timeSpent, "Time Spent")
        click(R.id.notifications, "Notifications")
        click(R.id.following, "Following")
        click(R.id.privacy, "Privacy Policy")
        click(R.id.terms, "Terms & Conditions")
        click(R.id.faq, "FAQ & Help")
    }

    fun click(id: Int, message: String) {
        findViewById<TextView>(id).setOnClickListener {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }


}

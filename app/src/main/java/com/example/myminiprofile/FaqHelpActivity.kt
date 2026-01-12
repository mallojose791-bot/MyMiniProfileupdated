package com.example.myminiprofile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.widget.Button

class FaqHelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faq_help)

        // Setup toolbar with back arrow
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = "FAQ & Help"
            setDisplayHomeAsUpEnabled(true)
        }

        // Setup button listeners for Quick Links
        findViewById<Button>(R.id.btnPrivacyPolicy).setOnClickListener {
            startActivity(Intent(this, PrivacyPolicyActivity::class.java))
        }

        findViewById<Button>(R.id.btnTermsConditions).setOnClickListener {
            startActivity(Intent(this, TermsConditionActivity::class.java))
        }
    }

    // Handle back arrow click
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
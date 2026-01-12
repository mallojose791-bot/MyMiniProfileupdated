package com.example.myminiprofile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.myminiprofile)  // ✅ FIXED!

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        // Load default fragment (Profile)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ProfileFragment())
                .commit()
            bottomNav.selectedItemId = R.id.nav_profile
        }

        // Handle navigation item clicks
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // TODO: Create and load HomeFragment if needed
                    true
                }
                R.id.nav_chat -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, ChatFragment())
                        .commit()
                    true
                }
                R.id.nav_apps -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, AppsFragment())
                        .commit()
                    true
                }
                R.id.nav_profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, ProfileFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}
package com.example.myminiprofile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.myminiprofile)

        setupBottomMenu()
    }

    private fun setupBottomMenu() {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        // Load HomeFragment by default
        openFragment(HomeFragment())

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_baseline_home_24 -> openFragment(HomeFragment())
                R.id.nav_profile -> openFragment(ChatFragment())
                R.id.nav_outline_apps_24 -> openFragment(AppsFragment())
                R.id.nav_baseline_person_24 -> openFragment(ProfileFragment())
            }
            true // Return true to indicate the click was handled
        }
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
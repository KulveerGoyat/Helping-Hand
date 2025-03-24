package com.example.helpinghand

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.helpinghand.fragments.HomeFragment
import com.example.helpinghand.fragments.ProfileFragment
import com.example.helpinghand.fragments.SettingsFragment
import com.example.helpinghand.fragments.AboutFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("DEPRECATION")
class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Set up the listener for Bottom Navigation selection
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.navigation_about -> {
                    loadFragment(AboutFragment())
                    true
                }
                R.id.navigation_profile -> {
                    loadFragment(ProfileFragment())
                    true
                }
                R.id.navigation_settings -> {
                    loadFragment(SettingsFragment())
                    true
                }
                else -> false
            }
        }

        // Load the default fragment when the activity starts
        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }
    }

    // Helper function to replace fragments
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }
}

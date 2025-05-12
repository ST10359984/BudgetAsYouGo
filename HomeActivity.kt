package com.example.budgetasyougo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Initialize bottom navigation and load the default fragment
        initViews()
    }

    private fun initViews() {
        bottomNavigation = findViewById(R.id.bottom_navigation)

        // Update the summary text
        val summaryTextView = findViewById<TextView>(R.id.summary_text)
        summaryTextView.text = "Your summary content here"

        loadFragment(HomeFragment()) // Load the default fragment

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> loadFragment(HomeFragment())
                R.id.nav_savings -> loadFragment(SavingsFragment())
                R.id.nav_family_budget -> loadFragment(FamilyBudgetFragment())
                R.id.nav_loans -> loadFragment(LoansFragment())
                R.id.nav_profile -> loadFragment(ProfileFragment())
                else -> false
            }
            true
        }
    }

    internal fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}

package com.example.budgetasyougo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view.findViewById<Button>(R.id.button_savings).setOnClickListener {
            (activity as HomeActivity).loadFragment(SavingsFragment())
        }
        view.findViewById<Button>(R.id.button_family).setOnClickListener {
            (activity as HomeActivity).loadFragment(FamilyBudgetFragment())
        }
        view.findViewById<Button>(R.id.button_loans).setOnClickListener {
            (activity as HomeActivity).loadFragment(LoansFragment())
        }
        view.findViewById<Button>(R.id.button_profile).setOnClickListener {
            (activity as HomeActivity).loadFragment(ProfileFragment())
        }

        return view
    }
}

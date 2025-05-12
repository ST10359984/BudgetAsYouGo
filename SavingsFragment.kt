package com.example.budgetasyougo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class SavingsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_savings, container, false)
        val savingsSummaryTextView = view.findViewById<TextView>(R.id.savings_summary_text_view)
        savingsSummaryTextView.text = getString(R.string.savings_summary)
        return view
    }
}

    private fun calculateSavings(): Double {
        val savings = 8000.00
        val expenses = 2500.00
        return savings - expenses
    }


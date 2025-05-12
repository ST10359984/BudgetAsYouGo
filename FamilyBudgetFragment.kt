package com.example.budgetasyougo

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FamilyBudgetFragment : Fragment() {
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? { //Inflate the layout
        val view = inflater.inflate(R.layout.fragment_family, container,false)
        //Referance the TextView
        val summaryTextView = view.findViewById<TextView>(R.id.family_budget_summary)
        //Calculate the remaining amount
        val remainingAmount = calculateRemainingAmount()
        //Display the remaining amount
        summaryTextView.text = "Remaining Balance: R$remainingAmount"
        return view
    }

    private fun calculateRemainingAmount(): Double{
        val savings = 5000.00
        val loans = 1500.00
        val familyBudget = 3000.00
        return savings + familyBudget - loans
    }
}

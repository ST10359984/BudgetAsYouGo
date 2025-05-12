package com.example.budgetasyougo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {
    private lateinit var profilePic: ImageView
    private lateinit var usernameTextView: TextView
    private lateinit var fullNameTextView: TextView
    private lateinit var logoutButton: Button
    private lateinit var addProfilePicButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        profilePic = view.findViewById(R.id.profile_picture)
        usernameTextView = view.findViewById(R.id.username)
        fullNameTextView = view.findViewById(R.id.full_name)
        logoutButton = view.findViewById(R.id.logout_button)
        addProfilePicButton = view.findViewById(R.id.add_profile_picture)

        setupProfile()
        return view
    }

    private fun setupProfile() {
        val username = "admin" // Fetch from DB or shared preferences
        val fullName = "Admin User" // Fetch from DB or shared preferences

        usernameTextView.text = username
        fullNameTextView.text = fullName

        addProfilePicButton.setOnClickListener {
            Toast.makeText(requireContext(), "Feature under construction", Toast.LENGTH_SHORT).show()
        }

        logoutButton.setOnClickListener {
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }
}

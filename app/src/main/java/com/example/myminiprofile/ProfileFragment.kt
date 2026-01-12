package com.example.myminiprofile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Personal Information
        view.findViewById<LinearLayout>(R.id.menuPersonalInfo).setOnClickListener {
            startActivity(Intent(requireContext(), PersonalInformationActivity::class.java))
        }

        // Notifications
        view.findViewById<LinearLayout>(R.id.menuNotifications).setOnClickListener {
            startActivity(Intent(requireContext(), NotificationsActivity::class.java))
        }

        // Time Spent
        view.findViewById<LinearLayout>(R.id.menuTimeSpent).setOnClickListener {
            startActivity(Intent(requireContext(), TimeSpentActivity::class.java))
        }

        // Following
        view.findViewById<LinearLayout>(R.id.menuFollowing).setOnClickListener {
            startActivity(Intent(requireContext(), FollowingActivity::class.java))
        }

        // Privacy Policy
        view.findViewById<LinearLayout>(R.id.menuPrivacyPolicy).setOnClickListener {
            startActivity(Intent(requireContext(), PrivacyPolicyActivity::class.java))
        }

        // Terms & Conditions
        view.findViewById<LinearLayout>(R.id.menuTermsConditions).setOnClickListener {
            startActivity(Intent(requireContext(), TermsConditionActivity::class.java))
        }

        // FAQ & Help
        view.findViewById<LinearLayout>(R.id.menuFaqHelp).setOnClickListener {
            startActivity(Intent(requireContext(), FaqHelpActivity::class.java))
        }

        // Log Out
        view.findViewById<LinearLayout>(R.id.btnLogout).setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Log Out")
                .setMessage("Are you sure you want to log out?")
                .setPositiveButton("Yes") { _, _ ->
                    Toast.makeText(requireContext(), "Logged out successfully", Toast.LENGTH_SHORT).show()
                    requireActivity().finishAffinity()
                }
                .setNegativeButton("Cancel", null)
                .show()
        }
    }
}
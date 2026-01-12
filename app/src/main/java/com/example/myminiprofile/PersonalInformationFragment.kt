package com.example.myminiprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class PersonalInformationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_personal_information, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Back button
        view.findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        // Set personal information data
        view.findViewById<TextView>(R.id.txtName).text = "Jose Mallo"
        view.findViewById<TextView>(R.id.txtAge).text = "23"
        view.findViewById<TextView>(R.id.txtAddress).text = "Cainta, Rizal, Philippines"
        view.findViewById<TextView>(R.id.txtGender).text = "Male"
    }
}


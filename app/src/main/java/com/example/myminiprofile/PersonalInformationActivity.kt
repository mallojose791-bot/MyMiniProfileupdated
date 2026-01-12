package com.example.myminiprofile

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.textfield.TextInputEditText

class PersonalInformationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_information)

        // 🔹 Set up toolbar with back arrow
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = "Personal Information"
            setDisplayHomeAsUpEnabled(true)
        }

        // Views - Changed from EditText to TextInputEditText
        val etName = findViewById<TextInputEditText>(R.id.etName)
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val etAge = findViewById<TextInputEditText>(R.id.etAge)
        val etAddress = findViewById<TextInputEditText>(R.id.etAddress)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val btnSave = findViewById<Button>(R.id.btnSave)

        val prefs = getSharedPreferences("user_profile", MODE_PRIVATE)

        // Load saved data
        etName?.setText(prefs.getString("name", ""))
        etEmail?.setText(prefs.getString("email", ""))
        etAge?.setText(prefs.getString("age", ""))
        etAddress?.setText(prefs.getString("address", ""))

        when (prefs.getString("gender", "")) {
            "Male" -> findViewById<RadioButton>(R.id.rbMale)?.isChecked = true
            "Female" -> findViewById<RadioButton>(R.id.rbFemale)?.isChecked = true
            "Other" -> findViewById<RadioButton>(R.id.rbOther)?.isChecked = true
            "Prefer not to say" -> findViewById<RadioButton>(R.id.rbPreferNot)?.isChecked = true
        }

        // SAVE BUTTON
        btnSave?.setOnClickListener {
            val selectedId = rgGender?.checkedRadioButtonId ?: -1
            val gender = if (selectedId != -1) {
                findViewById<RadioButton>(selectedId)?.text.toString()
            } else ""

            // Save values
            prefs.edit()
                .putString("name", etName?.text.toString())
                .putString("email", etEmail?.text.toString())
                .putString("age", etAge?.text.toString())
                .putString("address", etAddress?.text.toString())
                .putString("gender", gender)
                .apply()

            Toast.makeText(this, "Saved successfully", Toast.LENGTH_SHORT).show()

            // Go back to previous screen
            finish()
        }
    }

    // 🔹 Handle toolbar back arrow click
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
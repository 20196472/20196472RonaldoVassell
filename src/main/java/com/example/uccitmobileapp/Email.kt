package com.example.uccitmobileapp

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Email : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)

        val returnHomeButton = findViewById<Button>(R.id.return_home_button)
        val sendEmailButton = findViewById<Button>(R.id.send_email_button)



        sendEmailButton.setOnClickListener{

            val emailSubject = findViewById<EditText>(R.id.email_subject_input)
            val emailBody = findViewById<EditText>(R.id.email_body_input)
            val email = Intent(Intent.ACTION_SEND)
            email.type = "message/rfc822"
            email.putExtra(Intent.EXTRA_EMAIL,  "hod_email@ucc.edu")
            email.putExtra(Intent.EXTRA_SUBJECT, emailSubject.text.toString())
            email.putExtra(Intent.EXTRA_TEXT, emailBody.text.toString())
            try {
                startActivity(Intent.createChooser(email, "Send mail..."))
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(
                    this,
                    "There are no email clients installed.",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
        returnHomeButton.setOnClickListener {
            startActivity( Intent( this, MainActivity::class.java))
        }

    }
}
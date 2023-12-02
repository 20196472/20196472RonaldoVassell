package com.example.uccitmobileapp

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat
import android.Manifest
import android.content.ActivityNotFoundException
import android.widget.Toast

class Faculty_Staff_Directory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faculty_staff_directory)

        val swabyCall = findViewById<Button>(R.id.swaby_call_button)
        val davisCall = findViewById<Button>(R.id.davis_call_button)
        val roseCall = findViewById<Button>(R.id.rose_call_button)

        val swabyEmail = findViewById<Button>(R.id.swaby_email_button)
        val davisEmail = findViewById<Button>(R.id.davis_email_button)
        val roseEmail = findViewById<Button>(R.id.rose_email_button)

        checkPermission()

        swabyCall.setOnClickListener{
            val phoneNumber = "8762222222"
            makeCall(phoneNumber)

        }
        davisCall.setOnClickListener{
            val phoneNumber = "8760000000"
            makeCall(phoneNumber)

        }
        roseCall.setOnClickListener{
            val phoneNumber = "8761111111"
            makeCall(phoneNumber)

        }

        roseEmail.setOnClickListener{
            val email = "rose@ucc.edu"
            sendEmail(email)

        }
        davisEmail.setOnClickListener{
            val email = "davis@ucc.edu"
            sendEmail(email)

        }
        swabyEmail.setOnClickListener{
            val email = "swaby@ucc.edu"
            sendEmail(email)

        }
    }

    private fun checkPermission() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 101)
        }
    }

    private fun makeCall(number: String) {
        val call = Intent(Intent.ACTION_CALL)
        call.data = Uri.parse("tel:$number")
        startActivity(call)

    }

    private fun sendEmail(emailAddress: String) {
        val email = Intent(Intent.ACTION_SEND)
        email.type = "message/rfc822"
        email.putExtra(Intent.EXTRA_EMAIL,  emailAddress)

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
}
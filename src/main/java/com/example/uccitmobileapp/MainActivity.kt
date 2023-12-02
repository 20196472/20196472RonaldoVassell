package com.example.uccitmobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val facultyAndStaffButton = findViewById<ImageView>(R.id.DirectoryButton)
        val emailButton = findViewById<ImageView>(R.id.EmailButton)
        val socialButton = findViewById<ImageView>(R.id.SocialMediaButton)
        val coursesButton = findViewById<ImageView>(R.id.CoursesButton)
        val admissionButton = findViewById<ImageView>(R.id.AdmissionButton)

        facultyAndStaffButton.setOnClickListener {
            startActivity( Intent( this, Faculty_Staff_Directory::class.java))
        }

        emailButton.setOnClickListener {
            startActivity( Intent( this, Email::class.java))
        }

        socialButton.setOnClickListener{
            startActivity( Intent( this, SocialMedia::class.java))
        }

        coursesButton.setOnClickListener{
            startActivity(Intent(this, Courses::class.java))
        }

        admissionButton.setOnClickListener{
            startActivity(Intent(this, Admissions::class.java))
        }

    }
}
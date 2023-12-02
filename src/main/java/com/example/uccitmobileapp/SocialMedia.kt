package com.example.uccitmobileapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class SocialMedia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social_media)

        val instagramButton = findViewById<ImageView>(R.id.InstagramButton)
        val twitterButton = findViewById<ImageView>(R.id.TwitterButton)
        val facebookButton = findViewById<ImageView>(R.id.FacebookButton)
        val returnHomeButton = findViewById<Button>(R.id.social_return_home_button)

        instagramButton.setOnClickListener{
            val urlIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://instagram.com/uccjamaica?igshid=OGQ5ZDc2ODk2ZA==")
            )
            startActivity(urlIntent)
        }

        twitterButton.setOnClickListener{
            val urlIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://x.com/uccjamaica?s=11")
            )
            startActivity(urlIntent)
        }

        facebookButton.setOnClickListener{
            val urlIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.facebook.com/uccdsa?mibextid=LQQJ4d")
            )
            startActivity(urlIntent)
        }
        returnHomeButton.setOnClickListener {
            startActivity( Intent( this, MainActivity::class.java))
        }
    }
}
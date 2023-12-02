package com.example.uccitmobileapp

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class Courses : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)
        val layout = findViewById<LinearLayout>(R.id.courses_view)
//        val courseInfo = findViewById<TextView>(R.id.courses_data)
        //val homeButton = findViewById<Button>(R.id.course_return_home_button)
        val db = Firebase.firestore

        db.collection("courses")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    //Log.d(TAG, "${document.id} => ${document.data}")
                    Log.d(TAG, "${document.id} => ${document.data["code"]}")

                    var code = document.data["code"]
                    var credits = document.data.getValue("credits")
                    var preReq = document.data.getValue("preReq")
                    var name = document.data.getValue("name")
                    var description = document.data.getValue("description")
                    var info = "Code: " + code + "\nName: " + name + "\nCredits: " + credits +
                            "\nPre-requisites: " + preReq + "\nDescription: " + description + "\n"


                    val infoView = TextView(this)
                    infoView.text = info.toString()




                    layout.addView(infoView)

                }

            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }

//        homeButton.setOnClickListener{
//            startActivity( Intent( this, MainActivity::class.java))
//        }

    }
}
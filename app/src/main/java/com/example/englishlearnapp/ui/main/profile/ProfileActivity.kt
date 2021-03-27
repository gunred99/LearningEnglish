package com.example.englishlearnapp.ui.main.profile

import android.app.ActionBar
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.englishlearnapp.R
import com.example.englishlearnapp.ui.LaunchActivity
import com.example.englishlearnapp.ui.main.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ProfileActivity:AppCompatActivity() {
    private lateinit var signOut: Button
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_activity)

        auth = Firebase.auth

        signOut = findViewById(R.id.mBtnSignOut)
        signOut.setOnClickListener {
            auth!!.signOut()
            val intent = Intent(this, LaunchActivity::class.java)
            startActivity(intent)
        }

    }

}
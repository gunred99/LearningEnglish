package com.example.englishlearnapp.ui.main.developer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.englishlearnapp.R
import com.example.englishlearnapp.fcm.Firebase.Companion.auth
import com.example.englishlearnapp.ui.LaunchActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class DeveloperActivity: AppCompatActivity() {
    private lateinit var signOut: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.developer_activity)
        auth = Firebase.auth

        signOut = findViewById(R.id.mBtnSignOut)
        signOut.setOnClickListener {
            auth!!.signOut()
            val intent = Intent(this, LaunchActivity::class.java)
            startActivity(intent)
        }
    }
}
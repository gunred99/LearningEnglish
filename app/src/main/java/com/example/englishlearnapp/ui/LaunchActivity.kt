package com.example.englishlearnapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.englishlearnapp.R
import com.example.englishlearnapp.ui.login.LoginActivity
import com.example.englishlearnapp.ui.main.MainActivity
import com.example.englishlearnapp.ui.signin.SignInActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LaunchActivity: AppCompatActivity(){
    private lateinit var mBtnSignIn: Button
    private lateinit var mBtnLogin: Button
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.launch_activity)

        mBtnLogin = findViewById(R.id.mBtnLoginLaunch)
        mBtnSignIn = findViewById(R.id.mBtnSignupLaunch)
        auth = Firebase.auth
        val currentUser = auth.currentUser
        if(currentUser != null ){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        mBtnLogin.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }
        mBtnSignIn.setOnClickListener {
            val i = Intent(this, SignInActivity::class.java)
            startActivity(i)
        }
    }
}
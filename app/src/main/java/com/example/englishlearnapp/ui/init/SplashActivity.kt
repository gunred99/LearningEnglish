package com.example.englishlearnapp.ui.init

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.englishlearnapp.R
import com.example.englishlearnapp.ui.LaunchActivity

@Suppress("DEPRECATION")
class SplashActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        Handler().postDelayed({val intent = Intent(this, LaunchActivity::class.java)
            startActivity(intent)
            finish()}, 3000)
    }
}
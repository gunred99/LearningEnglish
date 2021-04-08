package com.example.englishlearnapp.ui.main.practice.Category

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.englishlearnapp.R
import com.example.englishlearnapp.ui.main.practice.Category.Questions.QuestionsActivity

class CategoryActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val startBtn : ImageButton = findViewById(R.id.startBtn)

        startBtn.setOnClickListener {
            val i = Intent (this, QuestionsActivity::class.java)
            startActivity(i)
        }
    }
}
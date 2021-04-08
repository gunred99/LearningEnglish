package com.example.englishlearnapp.ui.main.practices.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.englishlearnapp.R
import com.example.englishlearnapp.model.Questions
import com.example.englishlearnapp.ui.main.practices.adapter.OptionAdapter
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        bindView()
    }

    private fun bindView() {
        val questions = Questions(
            "What's your name?",
            "My name's Tony",
            "I'm fine, thanks",
            "Yes, I'm",
            "I'm 19 years old"
        )
        description.text = questions.description
        val optionAdapter = OptionAdapter(this, questions)
        optionList.layoutManager = LinearLayoutManager(this)
        optionList.adapter = optionAdapter
        optionList.setHasFixedSize(true)
    }
}
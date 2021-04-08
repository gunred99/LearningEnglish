package com.example.englishlearnapp.ui.main.practice

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.englishlearnapp.R
import com.example.englishlearnapp.model.StatFeed
import com.example.englishlearnapp.ui.main.practice.Category.CategoryActivity

class PracticeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.practice_activity)

        val allStat: ArrayList<StatFeed> = ArrayList()
        allStat.add(StatFeed("Total Score", R.drawable.icon_15_trophy))
        allStat.add(StatFeed("Total Test", R.drawable.group_25))
        allStat.add(StatFeed("Previous Score", R.drawable.iconfinder_12))
        allStat.add(StatFeed("Time Taken", R.drawable.group_24))

        val simpleGrid: GridView = findViewById(R.id.simpleGridView)
        simpleGrid.adapter = PracticeAdapter(this, allStat)

        val nextBtn = findViewById<ImageButton>(R.id.next_btn)
        nextBtn.setOnClickListener{
            val i = Intent(this, CategoryActivity::class.java)
            startActivity(i)
        }
    }
}
package com.example.englishlearnapp.ui.main.learn

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.englishlearnapp.R
import com.example.englishlearnapp.model.LearnTitle
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.learn_activity.*

class LearnActivity : AppCompatActivity(){

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mLearnViewModel: LearnViewModel
    private var list = mutableListOf<LearnTitle>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.learn_activity)

        val model = ViewModelProvider(this).get(LearnViewModel::class.java)
        mRecyclerView = findViewById(R.id.mRecyclerView)
        mRecyclerView.layoutManager = LinearLayoutManager(this@LearnActivity)


        model.listTitle.observe(this, Observer { listTitle ->
            mRecyclerView.adapter = LearnAdapter(listTitle)
        })
    }
//    override fun onLearnClick(item: LearnTitle, position: Int) {
//        Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show()
//    }
}
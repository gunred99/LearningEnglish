package com.example.englishlearnapp.ui.main.learn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.englishlearnapp.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class LearnActivity:AppCompatActivity() {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mLearnViewModel:LearnViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.learn_activity)

        mRecyclerView = findViewById(R.id.mRecyclerView)

        mRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@LearnActivity)
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()

            addItemDecoration(DividerItemDecoration(mRecyclerView.context, DividerItemDecoration.VERTICAL))

        }
        val model = ViewModelProvider(this).get(LearnViewModel::class.java)

        mLearnViewModel.databaseReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}
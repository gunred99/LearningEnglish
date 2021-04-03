package com.example.englishlearnapp.ui.main.learn

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.englishlearnapp.fcm.Firebase.Companion.firebaseDatabase
import com.example.englishlearnapp.model.LearnTitle
import com.google.firebase.database.*


class LearnViewModel : ViewModel() {
    var databaseReference = getLearnTitle()
    var listTitle = MutableLiveData<List<LearnTitle>>()
    var list = mutableListOf<LearnTitle>()

    init {
        getLearnTitle()
        getTitle()
    }

    private fun getLearnTitle(): DatabaseReference {
        return firebaseDatabase.getReference("Learning").child("NameTopic")
    }

    fun addListTitle(title: List<LearnTitle>) {
        listTitle.value = title
    }

    private fun getTitle() {
        databaseReference.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for (dataSnapShot: DataSnapshot in snapshot.children) {
                    val mReceive = dataSnapShot.getValue(LearnTitle::class.java)
                    list.add(mReceive!!)

                }
                addListTitle(list)
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}




package com.example.englishlearnapp.ui.main.learn

import androidx.lifecycle.ViewModel
import com.example.englishlearnapp.fcm.Firebase.Companion.firebaseDatabase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class LearnViewModel: ViewModel() {
    var databaseReference: DatabaseReference = getLearnTitle()

    private fun getLearnTitle(): DatabaseReference {
        return firebaseDatabase.getReference("Learning")
    }
}
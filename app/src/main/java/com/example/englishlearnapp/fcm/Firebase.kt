package com.example.englishlearnapp.fcm

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

open class Firebase {
    companion object {
        //get auth on Firebase
        var auth: FirebaseAuth = FirebaseAuth.getInstance()

        //get user on local
        val user: FirebaseUser? = auth.currentUser

        //import firebaseDatabase
        val firebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()

        //import firebaseStorage
         lateinit var firestore: FirebaseFirestore
    }
}
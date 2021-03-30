package com.example.englishlearnapp.ui.main.dictionary

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.*
import androidx.appcompat.app.AppCompatActivity
import com.example.englishlearnapp.R
import com.example.englishlearnapp.common.VNCharacterUtils
import com.example.englishlearnapp.model.Vocabulary
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.dictionary_activity.*


class DictionaryActivity : AppCompatActivity() {

    private lateinit var mTxtSearch: EditText
    private lateinit var mBtnSearch: Button
    private lateinit var mTxtResults: TextView
    private lateinit var mTxtResultsDescription: TextView
    var listVocabulary = mutableListOf<Vocabulary>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dictionary_activity)

        mTxtSearch = findViewById(R.id.txtSearch)
        mBtnSearch = findViewById(R.id.btnSearch)
        mTxtResults = findViewById(R.id.txtResults)
        mTxtResultsDescription = findViewById(R.id.txtResultsDescription)

        var database = FirebaseDatabase.getInstance()
        var ref = database.getReference("Dictionary")

        mBtnSearch.setOnClickListener() {

//            database.child("Dictionary").child("Vocabulary").child(txtVoNo.toString()).setValue(Vocabulary(txtVoNo, txtVoSearch, txtVoResult))

//            var txtSearch = mTxtSearch.text.toString()
//            var txt = VNCharacterUtils.removeAccent(txtSearch)
//
//            if (TextUtils.isEmpty(txt)) {
//                makeText(applicationContext, "No empty keyword allowed", LENGTH_SHORT).show()
//            }
//            else ref.child("Vocabulary").child(txt).setValue(object : ValueEventListener {
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    val voca = snapshot.getValue(Vocabulary::class.java)
//                    listVocabulary.add(voca!!)
//
//                    for (i in listVocabulary){
//                        if(txt == i.ta){
//                            mTxtResults.text = i.tv
//                            mTxtResultsDescription.text = i.description
//                        } else if(txt == i.tv){
//                            mTxtResults.text = i.ta
//                            mTxtResultsDescription.text = i.description
//                        }
//
//                    }
//
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//
//                }
//
//            })
            Translate()
        }

    }

    private fun Translate() {
        if(TextUtils.isEmpty(mTxtSearch.text.toString()))
        {
            Toast.makeText(this, "No empty word", Toast.LENGTH_SHORT).show()
        }
        else{
            var database = FirebaseDatabase.getInstance().getReference("Dictionary").child("Vocabulary")
            database.addValueEventListener(object : ValueEventListener{
                var searchKeyWord = mTxtSearch.text.toString()
                var searchKeyWordChar = VNCharacterUtils.removeAccent(searchKeyWord)
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.child(mTxtSearch.text.toString()).exists()){
                        txtResults.setText(snapshot.child(searchKeyWordChar).getValue().toString())
                    }
                    else{
                        Toast.makeText(this@DictionaryActivity, "No search result word", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
        }
    }

}

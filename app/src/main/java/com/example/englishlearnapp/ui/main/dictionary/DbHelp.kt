package com.example.englishlearnapp.ui.main.dictionary

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.lang.Exception

class DbHelp(context: Context, name: String, version: Int): SQLiteOpenHelper(context, name, null, version) {
    var mcontext: Context
    var dbName: String
    var dbPath: String
    init {
        mcontext = context
        dbName = name
        dbPath = "/data/data" + "com.example.englishlearnapp.ui.main.dictionary" + "/database"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        TODO("Not yet implemented")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
    fun checkDb(){
        try {
            var filePath = mcontext.getDatabasePath(dbName)
            if(!filePath.exists()) copyDatabase()
        }catch (e: Exception){
            e.stackTrace
        }

    }
    fun copyDatabase(){
//        this.readableDatabase
//        Log.d()
    }
}
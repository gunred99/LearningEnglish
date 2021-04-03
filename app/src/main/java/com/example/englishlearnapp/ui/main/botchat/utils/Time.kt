package com.example.englishlearnapp.ui.main.botchat.utils

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

object Time {

    fun timeStap(): String {
        val timeStap = Timestamp(System.currentTimeMillis())
        val sdf = SimpleDateFormat("HH:mm")
        val time = sdf.format(Date(timeStap.time))

        return time.toString()
    }
}
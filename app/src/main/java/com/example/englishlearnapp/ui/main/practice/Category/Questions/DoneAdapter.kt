package com.example.englishlearnapp.ui.main.practice.Category.Questions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.englishlearnapp.R
import com.example.englishlearnapp.model.DoneFeed

class DoneAdapter(private val context: Context, private val info: DoneFeed) : BaseAdapter()  {
    override fun getCount(): Int {
        return 1
    }

    override fun getItem(p0: Int): Any {
        return p0.toLong()
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(context)
        val statRow: View = layoutInflater.inflate(R.layout.done_list, p2, false)

        statRow.findViewById<TextView>(R.id.q_number).text = "Attempted Questions: ${info.qNumber}"

        return statRow
    }
}
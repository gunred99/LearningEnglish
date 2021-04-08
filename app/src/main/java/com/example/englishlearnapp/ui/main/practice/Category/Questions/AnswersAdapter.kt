package com.example.englishlearnapp.ui.main.practice.Category.Questions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.englishlearnapp.R
import org.w3c.dom.Text

class AnswersAdapter(private val context: Context, val answers: ArrayList<String>) : BaseAdapter() {
    override fun getCount(): Int {
        return answers.count()
    }

    override fun getItem(p0: Int): Any {
        return p0.toLong()
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(context)
        val answerRow: View = layoutInflater.inflate(R.layout.answers, p2, false)
        val answerNum = p0 + 1
        answerRow.findViewById<TextView>(R.id.answer_text).text = "${answers[p0]}"
        answerRow.findViewById<TextView>(R.id.answer_num).text = "${answerNum.toString()}"

        return answerRow
    }

}
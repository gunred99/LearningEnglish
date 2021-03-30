package com.example.englishlearnapp.ui.main.learn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.englishlearnapp.R
import com.example.englishlearnapp.model.LearnTitle

class LearnAdapter(private val learnTitle: List<LearnTitle>):
    RecyclerView.Adapter<LearnAdapter.ViewHolder>() {

    class ViewHolder(learnTitleView: View) : RecyclerView.ViewHolder(learnTitleView) {
        private val mLearnTitle = learnTitleView.findViewById<TextView>(R.id.mLearnView)
        fun binds(learnTitle: LearnTitle){
            val title = learnTitle.learnTitle
            mLearnTitle.text = learnTitle.learnTitle
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.learn_recyclerview, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binds(learnTitle[position])
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}
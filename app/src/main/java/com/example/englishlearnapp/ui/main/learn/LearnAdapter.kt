package com.example.englishlearnapp.ui.main.learn

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.englishlearnapp.R
import com.example.englishlearnapp.model.LearnTitle
import com.example.englishlearnapp.ui.main.learn.LearnByTopics.LearnByTopicsActivity

class LearnAdapter(private val learnTitle: List<LearnTitle>) :
    RecyclerView.Adapter<LearnAdapter.ViewHolder>() {

    class ViewHolder(learnTitleView: View) : RecyclerView.ViewHolder(learnTitleView) {

        private val mLearnTitle = learnTitleView.findViewById<TextView>(R.id.mLearnView)
        private val mLinearLayout = learnTitleView.findViewById<LinearLayout>(R.id.itemTitle)


        fun binds(title: LearnTitle) {
            mLearnTitle.text = title.name
            mLinearLayout.setOnClickListener{
                val i = Intent(itemView.context, LearnByTopicsActivity::class.java)
                itemView.context.startActivity(i)
            }
        }
    }

    interface onLearnClickListner{
        fun onLearnClick(item: LearnTitle, position: Int){

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.learn_recyclerview, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binds(learnTitle[position])

    }

    override fun getItemCount() = learnTitle.size


}
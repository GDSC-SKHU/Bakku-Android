package com.example.bakku.recyclerview.mypage

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bakku.R
import com.example.bakku.recyclerview.App

class MypageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val mypage_recycler_img : ImageView = itemView.findViewById(R.id.iv_mypage_recycler)
    private val mypage_recycler_name : TextView = itemView.findViewById(R.id.tv_mypage_recycler_name)
    private val mypage_recycler_date : TextView = itemView.findViewById(R.id.tv_mypage_recycler_date)
    private val mypage_recycler_kg : TextView = itemView.findViewById(R.id.tv_mypage_recycler_kg)

    // 데이터와 뷰를 묶는다
    fun bind(mypageModel: MypageModel) {

        mypage_recycler_name.text = mypageModel.name
        mypage_recycler_date.text = mypageModel.date
        mypage_recycler_kg.text = mypageModel.weight

        Glide
            .with(App.instance)
            .load(mypageModel.oceanImage)
   //         .centerCrop()
            .placeholder(R.drawable.ic_ocean)
            .into(mypage_recycler_img)
    }


}
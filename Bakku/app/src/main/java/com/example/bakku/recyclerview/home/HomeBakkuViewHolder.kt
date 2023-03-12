package com.example.bakku.recyclerview.home

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bakku.R
import com.example.bakku.recyclerview.App

class HomeBakkuViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
    private val home_bakku_recycler_img : ImageView = itemView.findViewById(R.id.iv_home_bakku_recycler)
    private val home_bakku_recycler_name : TextView = itemView.findViewById(R.id.tv_home_bakku_recycler_name)
    private val home_bakku_recycler_date : TextView = itemView.findViewById(R.id.tv_home_bakku_recycler_date)
    private val home_bakku_recycler_kg : TextView = itemView.findViewById(R.id.tv_home_bakku_recycler_kg)

    // 데이터와 뷰를 묶는다
    fun bind(homeBakkuModel: HomeBakkuModel) {

        home_bakku_recycler_name.text = homeBakkuModel.name
        home_bakku_recycler_date.text = homeBakkuModel.date
        home_bakku_recycler_kg.text = homeBakkuModel.weight

        Glide
            .with(App.instance)
            .load(homeBakkuModel.oceanImage)
            //         .centerCrop()
            .placeholder(R.drawable.ic_ocean)
            .into(home_bakku_recycler_img)
    }
}
package com.example.bakku.recyclerview.home

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bakku.R
import com.example.bakku.recyclerview.App

class HomeOceanViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
    private val home_ocean_recycler_img : ImageView =  itemView.findViewById(R.id.iv_home_ocean_recycler)
    private val home_ocean_recycler_sea : TextView = itemView.findViewById(R.id.tv_home_ocean_recycler_sea)
    private val home_ocean_recycler_location : TextView = itemView.findViewById(R.id.tv_home_ocean_recycler_location)

    // 데이터와 뷰를 묶는다
    fun bind(homeOceanModel: HomeOceanModel) {

        home_ocean_recycler_sea.text = homeOceanModel.sea
        home_ocean_recycler_location.text = homeOceanModel.location

        Glide
            .with(App.instance)
            .load(homeOceanModel.oceanImg)
            //         .centerCrop()
            .placeholder(R.drawable.ic_ocean)
            .into(home_ocean_recycler_img)
    }
}
package com.example.bakku.recyclerview.bakkudetail

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bakku.R
import com.example.bakku.recyclerview.App

class BakkuDetailViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
    private val bakku_detail_recycler_img : ImageView = itemView.findViewById(R.id.iv_bakku_detail_recycler)
    private val bakku_detail_recycler_name : TextView = itemView.findViewById(R.id.tv_bakku_detail_recycler_name)
    private val bakku_detail_recycler_date : TextView = itemView.findViewById(R.id.tv_bakku_detail_recycler_date)
    private val bakku_detail_recycler_kg : TextView = itemView.findViewById(R.id.tv_bakku_detail_recycler_kg)

    // 데이터와 뷰를 묶는다
    fun bind(bakkuDetailModel: BakkuDetailModel) {

        bakku_detail_recycler_name.text = bakkuDetailModel.name
        bakku_detail_recycler_date.text = bakkuDetailModel.date
        bakku_detail_recycler_kg.text = bakkuDetailModel.weight

        Glide
            .with(App.instance)
            .load(bakkuDetailModel.oceanImage)
            //         .centerCrop()
            .placeholder(R.drawable.ic_ocean)
            .into(bakku_detail_recycler_img)
    }
}
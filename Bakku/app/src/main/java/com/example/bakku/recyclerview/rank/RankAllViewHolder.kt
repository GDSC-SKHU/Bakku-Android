package com.example.bakku.recyclerview.rank

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bakku.R
import com.example.bakku.recyclerview.App

class RankAllViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val rank_all_recycler_img : ImageView = itemView.findViewById(R.id.iv_rank_all_recycler)
    private val rank_all_recycler_name : TextView = itemView.findViewById(R.id.tv_rank_all_recycler_name)
    private val rank_all_recycler_date : TextView = itemView.findViewById(R.id.tv_rank_all_recycler_date)
    private val rank_all_recycler_kg : TextView = itemView.findViewById(R.id.tv_rank_all_recycler_kg)

    // 데이터와 뷰를 묶는다
    fun bind(rankAllModel: RankAllModel) {

        rank_all_recycler_name.text = rankAllModel.name
        rank_all_recycler_date.text = rankAllModel.date
        rank_all_recycler_kg.text = rankAllModel.weight

        Glide
            .with(App.instance)
            .load(rankAllModel.oceanImage)
            //         .centerCrop()
            .placeholder(R.drawable.ic_ocean)
            .into(rank_all_recycler_img)
    }
}
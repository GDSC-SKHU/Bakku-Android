package com.example.bakku.recyclerview.rank

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bakku.R
import com.example.bakku.recyclerview.App
import com.example.bakku.recyclerview.mypage.MypageModel

class RankOceanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val rank_ocean_recycler_img : ImageView = itemView.findViewById(R.id.iv_rank_ocean_recycler)
    private val rank_ocean_recycler_name : TextView = itemView.findViewById(R.id.tv_rank_ocean_recycler_name)
    private val rank_ocean_recycler_date : TextView = itemView.findViewById(R.id.tv_rank_ocean_recycler_date)
    private val rank_ocean_recycler_kg : TextView = itemView.findViewById(R.id.tv_rank_ocean_recycler_kg)

    // 데이터와 뷰를 묶는다
    fun bind(rankOceanModel: RankOceanModel) {

        rank_ocean_recycler_name.text = rankOceanModel.name
        rank_ocean_recycler_date.text = rankOceanModel.date
        rank_ocean_recycler_kg.text = rankOceanModel.weight

        Glide
            .with(App.instance)
            .load(rankOceanModel.oceanImage)
            //         .centerCrop()
            .placeholder(R.drawable.ic_ocean)
            .into(rank_ocean_recycler_img)
    }
}
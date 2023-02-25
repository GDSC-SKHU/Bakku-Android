package com.example.bakku.recyclerview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bakku.R
import com.example.bakku.databinding.ItemHomeSeaBinding
import com.example.bakku.data.local.SeaModel

class SeaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val seaTextView = itemView.findViewById<TextView>(R.id.tv_home_sea_recycler)
    private val locationTextView = itemView.findViewById<TextView>(R.id.tv_home_location_recycler)
    private val seaImageView = itemView.findViewById<ImageView>(R.id.iv_home_sea_recycler)

    // 데이터와 뷰 묶음
    fun bind(seaModel: SeaModel){
        //텍스트뷰와 실제 텍스트 데이터 묶음
        seaTextView.text = seaModel.name

        //이미지뷰와 실제 이미지 데이터를 묶음
        Glide
            .with(App.instance)
            .load(seaModel.seaImage)
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher)
            .into(seaImageView)
    }
}
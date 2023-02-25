package com.example.bakku.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bakku.R
import com.example.bakku.data.local.SeaModel

class SeaRecyclerAdapter: RecyclerView.Adapter<SeaViewHolder>(){

    private var seaList = ArrayList<SeaModel>()

    //뷰 홀더가 생성 되었을 때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeaViewHolder {
        //연결할 레이아웃 설정
        return SeaViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_sea,parent))
    }

    // 목록의 아이템 수
    override fun getItemCount(): Int {
        return this.seaList.size
    }

    //뷰와 뷰홀더가 묶였을 때
    override fun onBindViewHolder(holder: SeaViewHolder, position: Int) {
        holder.bind(this.seaList[position])
    }

    fun submitList(seaList: ArrayList<SeaModel>){
        this.seaList = seaList
    }


}
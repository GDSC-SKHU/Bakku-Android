package com.example.bakku.recyclerview.rank

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bakku.R
import com.example.bakku.recyclerview.mypage.MypageModel
import com.example.bakku.recyclerview.mypage.MypageViewHolder

class RankOceanRecyclerAdapter: RecyclerView.Adapter<RankOceanViewHolder>() {
    private var modelList = ArrayList<RankOceanModel>()

    //뷰 홀더가 생성 되었을 때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankOceanViewHolder {
        return RankOceanViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_rank_ocean_recycler_item,parent,false))
    }

    // 목록의 아이템 수
    override fun getItemCount(): Int {
        return modelList.size
    }

    // 아이템 추가
    fun addItem(item: RankOceanModel) {
        modelList.add(item)
        notifyDataSetChanged()
    }

    // 뷰와 뷰홀더가 묶였을 때
    override fun onBindViewHolder(holder: RankOceanViewHolder, position: Int) {
        holder.bind(this.modelList[position])
    }

    // 외부에서 데이터 넘기기
    fun submitList(modelList: ArrayList<RankOceanModel>) {
        this.modelList = modelList
    }
}
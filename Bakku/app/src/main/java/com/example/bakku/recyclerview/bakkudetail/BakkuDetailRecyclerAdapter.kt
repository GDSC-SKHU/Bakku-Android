package com.example.bakku.recyclerview.bakkudetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bakku.R


class BakkuDetailRecyclerAdapter: RecyclerView.Adapter<BakkuDetailViewHolder>() {
    private var modelList = ArrayList<BakkuDetailModel>()

    //뷰 홀더가 생성 되었을 때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BakkuDetailViewHolder {
        return BakkuDetailViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_bakku_detail_recycler_item,parent,false))
    }

    // 목록의 아이템 수
    override fun getItemCount(): Int {
        return modelList.size
    }

    // 아이템 추가
    fun addItem(item: BakkuDetailModel) {
        modelList.add(item)
        notifyDataSetChanged()
    }

    // 뷰와 뷰홀더가 묶였을 때
    override fun onBindViewHolder(holder: BakkuDetailViewHolder, position: Int) {
        holder.bind(this.modelList[position])
    }

    // 외부에서 데이터 넘기기
    fun submitList(modelList: ArrayList<BakkuDetailModel>) {
        this.modelList = modelList
    }
}
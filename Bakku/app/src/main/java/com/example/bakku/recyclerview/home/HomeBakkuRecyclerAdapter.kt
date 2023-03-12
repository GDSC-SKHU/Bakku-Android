package com.example.bakku.recyclerview.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bakku.R

class HomeBakkuRecyclerAdapter: RecyclerView.Adapter<HomeBakkuViewHolder>() {
    private var modelList = ArrayList<HomeBakkuModel>()

    //뷰 홀더가 생성 되었을 때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBakkuViewHolder {
        return HomeBakkuViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_home_bakku_recycler_item,parent,false))
    }

    // 목록의 아이템 수
    override fun getItemCount(): Int {
        return 10
    }

    // 아이템 추가
    fun addItem(item: HomeBakkuModel) {
        modelList.add(item)
        notifyDataSetChanged()
    }

    // 뷰와 뷰홀더가 묶였을 때
    override fun onBindViewHolder(holder: HomeBakkuViewHolder, position: Int) {
        holder.bind(this.modelList[position])
    }

    // 외부에서 데이터 넘기기
    fun submitList(modelList: ArrayList<HomeBakkuModel>) {
        this.modelList = modelList
    }
}
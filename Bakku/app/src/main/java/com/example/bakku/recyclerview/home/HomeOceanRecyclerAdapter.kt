package com.example.bakku.recyclerview.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bakku.R


class HomeOceanRecyclerAdapter/*(homeOceanRecyclerviewInterface: HomeOceanRecyclerviewInterface)*/: RecyclerView.Adapter<HomeOceanViewHolder>() {
    private var modelList = ArrayList<HomeOceanModel>()

    private var homeOceanRecyclerviewInerface : HomeOceanRecyclerviewInterface? = null

    /*init {
        this.homeOceanRecyclerviewInerface = homeOceanRecyclerviewInterface
    }*/

    //뷰 홀더가 생성 되었을 때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeOceanViewHolder {
        return HomeOceanViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_home_ocean_recycler_item,parent,false))
    }

    // 목록의 아이템 수
    override fun getItemCount(): Int {
        return 10
    }

    // 아이템 추가
    fun addItem(item: HomeOceanModel) {
        modelList.add(item)
        notifyDataSetChanged()
    }

    // 뷰와 뷰홀더가 묶였을 때
    override fun onBindViewHolder(holder: HomeOceanViewHolder, position: Int) {
        holder.bind(this.modelList[position])
    }

    // 외부에서 데이터 넘기기
    fun submitList(modelList: ArrayList<HomeOceanModel>) {
        this.modelList = modelList
    }
}
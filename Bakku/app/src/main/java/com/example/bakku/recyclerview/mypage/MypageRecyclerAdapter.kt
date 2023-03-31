package com.example.bakku.recyclerview.mypage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bakku.R

class MypageRecyclerAdapter : RecyclerView.Adapter<MypageViewHolder>() {

    private var modelList = ArrayList<MypageModel>()

    //뷰 홀더가 생성 되었을 때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MypageViewHolder {
        return MypageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_my_recycler_item,parent,false))
    }

    // 목록의 아이템 수
    override fun getItemCount(): Int {
        return modelList.size
    }

    // 아이템 추가
    fun addItem(item:MypageModel) {
        modelList.add(item)
        notifyDataSetChanged()
    }

    // 뷰와 뷰홀더가 묶였을 때
    override fun onBindViewHolder(holder: MypageViewHolder, position: Int) {
        holder.bind(this.modelList[position])
    }

    // 외부에서 데이터 넘기기
    fun submitList(modelList: ArrayList<MypageModel>) {
        this.modelList = modelList
    }

}
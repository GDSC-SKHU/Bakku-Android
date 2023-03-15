package com.example.bakku.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bakku.R
import com.example.bakku.recyclerview.rank.RankAllModel
import com.example.bakku.recyclerview.rank.RankAllRecyclerAdapter

class RankAllFragment : Fragment() {

    // 데이터를 잠을 그릇 즉 배열에 RankAllModel
    var modelList = ArrayList<RankAllModel>()

    private lateinit var rankAllRecyclerAdapter: RankAllRecyclerAdapter
    private lateinit var rank_all_recycler_view : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_rank_all, container, false)
        val spinner: Spinner = rootView.findViewById(R.id.sp_rank_all)

        // Spinner 아이템 추가
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.rank_all,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        // 10번 반복
        for(i in 1 .. 10){
            var rankAllModel = RankAllModel(name = "성공회대학교", oceanImage = "https://news.samsungdisplay.com/wp-content/uploads/2022/05/IT_twi001t1345955-1-1024x639.jpg", date = "2023-03-12", weight = "10kg")
            this.modelList.add(rankAllModel)
        }

        // 어탑터 인스턴스 생성
        rankAllRecyclerAdapter = RankAllRecyclerAdapter()
        rankAllRecyclerAdapter.submitList(this.modelList)

        // 리사이클러뷰 설정
        rank_all_recycler_view = rootView.findViewById(R.id.rank_all_recycler_view)
        rank_all_recycler_view.apply{
            // 리사이클러뷰 방향 등 설정
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
            // 어답터 장착
            adapter = rankAllRecyclerAdapter
        }

        return rootView
    }

}
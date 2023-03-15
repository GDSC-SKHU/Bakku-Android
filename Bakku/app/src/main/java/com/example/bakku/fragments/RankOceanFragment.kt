package com.example.bakku.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bakku.R
import com.example.bakku.recyclerview.mypage.MypageModel
import com.example.bakku.recyclerview.mypage.MypageRecyclerAdapter
import com.example.bakku.recyclerview.rank.RankAllModel
import com.example.bakku.recyclerview.rank.RankAllRecyclerAdapter
import com.example.bakku.recyclerview.rank.RankOceanModel
import com.example.bakku.recyclerview.rank.RankOceanRecyclerAdapter

class RankOceanFragment : Fragment() {

    // 데이터를 잠을 그릇 즉 배열에 MypageModel
    var modelList = ArrayList<RankOceanModel>()

    private lateinit var rankOceanRecyclerAdapter: RankOceanRecyclerAdapter
    private lateinit var rank_ocean_recycler_view : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_rank_ocean, container, false)
        val spinner: Spinner = rootView.findViewById(R.id.sp_rank_ocean)

        // Spinner 아이템 추가
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.rank_seas,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        // 10번 반복
        for(i in 1 .. 10){
            var rankOceanModel = RankOceanModel(name = "성공회대학교", oceanImage = "https://news.samsungdisplay.com/wp-content/uploads/2022/05/IT_twi001t1345955-1-1024x639.jpg", date = "2023-03-12", weight = "10kg")
            this.modelList.add(rankOceanModel)
        }

        // 어탑터 인스턴스 생성
        rankOceanRecyclerAdapter = RankOceanRecyclerAdapter()
        rankOceanRecyclerAdapter.submitList(this.modelList)

        // 리사이클러뷰 설정
        rank_ocean_recycler_view = rootView.findViewById(R.id.rank_ocean_recycler_view)
        rank_ocean_recycler_view.apply{
            // 리사이클러뷰 방향 등 설정
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
            // 어답터 장착
            adapter = rankOceanRecyclerAdapter
        }


        return rootView
    }

}
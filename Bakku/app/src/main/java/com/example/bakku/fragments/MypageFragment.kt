package com.example.bakku.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bakku.R
import com.example.bakku.recyclerview.mypage.MypageModel
import com.example.bakku.recyclerview.mypage.MypageRecyclerAdapter

class MypageFragment : Fragment() {

    // 데이터를 잠을 그릇 즉 배열에 MypageModel
    var modelList = ArrayList<MypageModel>()

    private lateinit var mypageRecyclerAdapter: MypageRecyclerAdapter
    private lateinit var my_recycler_view : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mypage , container, false)

        // 10번 반복
        for(i in 1 .. 10){
            var mypageModel = MypageModel(name = "성공회대학교", oceanImage = "https://news.samsungdisplay.com/wp-content/uploads/2022/05/IT_twi001t1345955-1-1024x639.jpg", date = "2023-03-12")
            this.modelList.add(mypageModel)
        }

        // 어탑터 인스턴스 생성
        mypageRecyclerAdapter = MypageRecyclerAdapter()
        mypageRecyclerAdapter.submitList(this.modelList)

        // 리사이클러뷰 설정
        my_recycler_view = view.findViewById(R.id.my_recycler_view)
        my_recycler_view.apply{
            // 리사이클러뷰 방향 등 설정
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            // 어답터 장착
            adapter = mypageRecyclerAdapter
        }

        return view
    }
}
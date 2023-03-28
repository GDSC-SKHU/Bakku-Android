package com.example.bakku.fragments

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.bakku.data.remote.response.EventResponse


class HomeSlideAdapter : FragmentStateAdapter {
    var mCount : Int
    var mEvents: ArrayList<EventResponse>

    constructor(f: Fragment, count: Int, events: ArrayList<EventResponse>) : super(f){
        mCount = count // 생성할 프래그먼트 개수
        mEvents = events
    }

    override fun createFragment(position: Int): Fragment {
        val index = getRealPosition(position)

        return HomeSlide1Fragment(mEvents[index])
    }

    //프래그먼트를 계속 슬라이딩하기 위해 2000으로 임의 설정
    override fun getItemCount(): Int {
        return 2000
    }

    fun getRealPosition(position: Int): Int {
        //position에서 프래그먼트 개수로 나눈 나머지 값이 진짜 position
        return position % mCount
    }
}
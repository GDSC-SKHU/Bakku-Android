package com.example.bakku.fragments

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter


class HomeSlideAdapter : FragmentStateAdapter {
    var mCount : Int

    constructor(f: Fragment, count: Int) : super(f){
        mCount = count // 생성할 프래그먼트 개수
    }

    override fun createFragment(position: Int): Fragment {
        val index = getRealPosition(position)

        if (index == 0)
            return HomeSlide1Fragment()
        else if (index == 1)
            return HomeSlide2Fragment()
        else
            return HomeSlide3Fragment()

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
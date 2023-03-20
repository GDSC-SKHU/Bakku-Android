package com.example.bakku.fragments

//import com.example.bakku.fragments.ViewPagerAdapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.bakku.R
import com.example.bakku.databinding.FragmentHomeBinding

import com.example.bakku.recyclerview.home.*
import com.example.bakku.recyclerview.mypage.MypageModel
import com.example.bakku.recyclerview.mypage.MypageRecyclerAdapter

import me.relex.circleindicator.CircleIndicator3
import java.text.FieldPosition


class HomeFragment : Fragment() ,HomeOceanRecyclerviewInterface {

    //private var mBinding : FragmentHomeBinding? = null

    //slide view here
    private lateinit var mPager : ViewPager2
    private lateinit var pagerAdapter: FragmentStateAdapter
    private var num_page : Int = 4
    private lateinit var mIndicator: CircleIndicator3

    //recycler view
    // 데이터를 잠을 그릇 즉 배열에 MypageModel
    var modelList1 = ArrayList<HomeOceanModel>()
    var modelList2 = ArrayList<HomeBakkuModel>()

    private lateinit var homeOceanRecyclerAdapter: HomeOceanRecyclerAdapter
    private lateinit var home_ocean_recycler_view : RecyclerView

    private lateinit var homeBakkuRecyclerAdapter: HomeBakkuRecyclerAdapter
    private lateinit var home_bakku_recycler_view : RecyclerView



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // fragment에서 findViewById 사용 (viewpager 부분)
        val v : View = inflater.inflate(R.layout.fragment_home,container,false)


        //ViewPager2
        mPager = v.findViewById(R.id.viewpager)
        //Adapter
        pagerAdapter = HomeSlideAdapter(this, num_page)
        mPager.adapter = pagerAdapter
        //Indicator
        mIndicator = v.findViewById(R.id.indicator)
        mIndicator.setViewPager(mPager)
        mIndicator.createIndicators(num_page, 0)
        //ViewPager Setting
        mPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        mPager.currentItem = 1000
        mPager.offscreenPageLimit = 3

        mPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                if (positionOffsetPixels == 0) {
                    mPager.currentItem = position
                }
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                mIndicator.animatePageSelected(position % num_page)
            }
        })
        val pageMargin = resources.getDimensionPixelOffset(R.dimen.pageMargin).toFloat()
        val pageOffset = resources.getDimensionPixelOffset(R.dimen.offset).toFloat()

        mPager.setPageTransformer { page, position ->
            val myOffset = position * -(2 * pageOffset + pageMargin)
            if (mPager.orientation == ViewPager2.ORIENTATION_HORIZONTAL) {
                if (ViewCompat.getLayoutDirection(mPager) == ViewCompat.LAYOUT_DIRECTION_RTL) {
                    page.translationX = -myOffset
                } else {
                    page.translationX = myOffset
                }
            } else {
                page.translationY = myOffset
            }
        }

        // 10번 반복
        for(i in 1 .. 10){
            var homeOceanModel = HomeOceanModel(sea = "을왕리 해수욕장", location = "을왕리", oceanImg = "https://news.samsungdisplay.com/wp-content/uploads/2022/05/IT_twi001t1345955-1-1024x639.jpg")
            this.modelList1.add(homeOceanModel)
        }

        // 어탑터 인스턴스 생성
        homeOceanRecyclerAdapter = HomeOceanRecyclerAdapter(this)
        homeOceanRecyclerAdapter.submitList(this.modelList1)

        // 리사이클러뷰 설정
        home_ocean_recycler_view = v.findViewById(R.id.home_sea_recycler_view)
        home_ocean_recycler_view.apply{
            // 리사이클러뷰 방향 등 설정
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            // 어답터 장착
            adapter = homeOceanRecyclerAdapter
        }

        // 10번 반복
        for(i in 1 .. 10){
            var homeBakkuModel = HomeBakkuModel(name = "성공회대학교", oceanImage = "https://news.samsungdisplay.com/wp-content/uploads/2022/05/IT_twi001t1345955-1-1024x639.jpg", date = "2023-03-12", weight = "10kg")
            this.modelList2.add(homeBakkuModel)
        }

        // 어탑터 인스턴스 생성
        homeBakkuRecyclerAdapter = HomeBakkuRecyclerAdapter()
        homeBakkuRecyclerAdapter.submitList(this.modelList2)

        // 리사이클러뷰 설정
        home_bakku_recycler_view = v.findViewById(R.id.home_bakku_recycler_view)
        home_bakku_recycler_view.apply{
            // 리사이클러뷰 방향 등 설정
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            // 어답터 장착
            adapter = homeBakkuRecyclerAdapter
        }


        return v
    }

    override fun onItemClicked(position: Int) {
        val fragment = OceanDetailFragment()
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.homeFragment,fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

}
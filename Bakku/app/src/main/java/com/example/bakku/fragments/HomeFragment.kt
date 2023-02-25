package com.example.bakku.fragments

//import com.example.bakku.fragments.ViewPagerAdapter

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
import com.example.bakku.data.local.SeaModel
import com.example.bakku.recyclerview.SeaRecyclerAdapter
import me.relex.circleindicator.CircleIndicator3


class HomeFragment : Fragment() {

    private var mBinding : FragmentHomeBinding? = null

    //slide view here
    private lateinit var mPager : ViewPager2
    private lateinit var pagerAdapter: FragmentStateAdapter
    private var num_page: Int = 4
    private lateinit var mIndicator: CircleIndicator3

    //recycler view
    //데이터를 담을 배열
    var seaList = ArrayList<SeaModel>()

    private lateinit var seaRecyclerAdapter: SeaRecyclerAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentHomeBinding.inflate(inflater,container,false)
        mBinding = binding

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
        //slide view end

        //recycler view
        for (i in 1..10){
            var seaModel = SeaModel("해수욕장 $i","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRqs11H00-aBaQjtB11-pSYYSqQRluXw3qWa4UuaHVKzA&s","주소 $i")
            this.seaList.add(seaModel)
        }

        //어답터 인스턴스 생성
        seaRecyclerAdapter = SeaRecyclerAdapter()
        seaRecyclerAdapter.submitList(this.seaList)

        //리사이클러뷰 설정
        val home_sea_recycler_view = v.findViewById<RecyclerView>(R.id.home_sea_recycler_view)
        home_sea_recycler_view.apply {
            //context 부분 this@HomeFragment
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

            //어답터 장착
            adapter = seaRecyclerAdapter
        }

        return mBinding?.root
    }
    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }

}
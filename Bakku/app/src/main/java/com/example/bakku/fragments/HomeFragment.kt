package com.example.bakku.fragments

//import com.example.bakku.fragments.ViewPagerAdapter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.bakku.R
import com.example.bakku.data.remote.RetrofitClient
import com.example.bakku.data.remote.api.EventService
import com.example.bakku.data.remote.response.EventResponse
import com.example.bakku.data.remote.response.Paging

import com.example.bakku.recyclerview.home.*


import me.relex.circleindicator.CircleIndicator3
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment(), HomeOceanRecyclerviewInterface {

    //private var mBinding : FragmentHomeBinding? = null

    //slide view here
    private lateinit var mPager: ViewPager2
    private lateinit var pagerAdapter: FragmentStateAdapter
    private var num_page: Int = 4
    private lateinit var mIndicator: CircleIndicator3

    //recycler view
    // 데이터를 잠을 그릇 즉 배열에 MypageModel
    var modelList1 = ArrayList<HomeOceanModel>()
    var modelList2 = ArrayList<HomeBakkuModel>()

    private lateinit var homeOceanRecyclerAdapter: HomeOceanRecyclerAdapter
    private lateinit var home_ocean_recycler_view: RecyclerView

    private lateinit var homeBakkuRecyclerAdapter: HomeBakkuRecyclerAdapter
    private lateinit var home_bakku_recycler_view: RecyclerView

    // data from api
    private var events : MutableLiveData<ArrayList<EventResponse>> = MutableLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val eventService = RetrofitClient.retrofit.create(EventService::class.java)

        eventService.getEvents().enqueue(object : Callback<Paging<EventResponse>> {
            override fun onResponse(
                call: Call<Paging<EventResponse>>, response: Response<Paging<EventResponse>>
            ) {
                if (response.isSuccessful()) {

                    events.value = response.body()!!.content
                }
                //TODO("여기에 에러 핸들링 하세요")

            }

            override fun onFailure(call: Call<Paging<EventResponse>>, t: Throwable) {
                TODO("여기에 에러 핸들링 하세요")
0            }
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // fragment에서 findViewById 사용 (viewpager 부분)
        val v: View = inflater.inflate(R.layout.fragment_home, container, false)


        // when events observed, set up viewpager
        events.observe(viewLifecycleOwner, Observer {

            //ViewPager2
            mPager = v.findViewById(R.id.viewpager)
            //Adapter
            pagerAdapter = HomeSlideAdapter(this, num_page, it)
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
                    position: Int, positionOffset: Float, positionOffsetPixels: Int
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
        })


        // 10번 반복
        for (i in 1..10) {
            var homeOceanModel = HomeOceanModel(
                sea = "을왕리 해수욕장",
                location = "을왕리",
                oceanImg = "https://news.samsungdisplay.com/wp-content/uploads/2022/05/IT_twi001t1345955-1-1024x639.jpg"
            )
            this.modelList1.add(homeOceanModel)
        }

        // 어탑터 인스턴스 생성
        homeOceanRecyclerAdapter = HomeOceanRecyclerAdapter(this)
        homeOceanRecyclerAdapter.submitList(this.modelList1)

        // 리사이클러뷰 설정
        home_ocean_recycler_view = v.findViewById(R.id.home_sea_recycler_view)
        home_ocean_recycler_view.apply {
            // 리사이클러뷰 방향 등 설정
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            // 어답터 장착
            adapter = homeOceanRecyclerAdapter
        }

        // 10번 반복
        for (i in 1..10) {
            var homeBakkuModel = HomeBakkuModel(
                name = "성공회대학교",
                oceanImage = "https://news.samsungdisplay.com/wp-content/uploads/2022/05/IT_twi001t1345955-1-1024x639.jpg",
                date = "2023-03-12",
                weight = "10kg"
            )
            this.modelList2.add(homeBakkuModel)
        }

        // 어탑터 인스턴스 생성
        homeBakkuRecyclerAdapter = HomeBakkuRecyclerAdapter()
        homeBakkuRecyclerAdapter.submitList(this.modelList2)

        // 리사이클러뷰 설정
        home_bakku_recycler_view = v.findViewById(R.id.home_bakku_recycler_view)
        home_bakku_recycler_view.apply {
            // 리사이클러뷰 방향 등 설정
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            // 어답터 장착
            adapter = homeBakkuRecyclerAdapter
        }


        return v
    }

    override fun onItemClicked(position: Int) {
        val fragment = OceanDetailFragment()
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.homeFragment, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

}
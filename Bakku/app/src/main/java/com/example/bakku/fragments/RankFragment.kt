package com.example.bakku.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.bakku.R

import com.google.android.material.tabs.TabLayout

class RankFragment : Fragment() {

    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_rank, container, false)
        viewPager = view.findViewById(R.id.viewpager)
        tabLayout = view.findViewById(R.id.tabs)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up the ViewPager with the sections adapter.
        val sectionsPagerAdapter = SectionsPagerAdapter(childFragmentManager)
        viewPager.adapter = sectionsPagerAdapter

        // Connect the TabLayout and the ViewPager.
        tabLayout.setupWithViewPager(viewPager)
    }

    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            // Return the Fragment corresponding to the current tab.
            return when (position) {
                0 -> RankAllFragment()
                1 -> RankOceanFragment()
                else -> throw IllegalArgumentException("Invalid tab position")
            }
        }

        override fun getCount(): Int {
            // Show 2 total pages.
            return 2
        }

        override fun getPageTitle(position: Int): CharSequence? {
            // Set the title for each tab.
            return when (position) {
                0 -> getString(R.string.tab1_title)
                1 -> getString(R.string.tab2_title)
                else -> null
            }
        }
    }


    /*private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rank, container, false)

        tabLayout = view.findViewById(R.id.tabs)
        viewPager = view.findViewById(R.id.viewpager)

        // 어댑터 생성
        val adapter = MyPagerAdapter(childFragmentManager)

        // 탭 페이지 추가
        adapter.addFragment(RankAllFragment(), "전체")
        adapter.addFragment(RankOceanFragment(), "해수욕장별")

        // 어댑터 설정
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

        return view

    }

    private class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        private val fragmentList = ArrayList<Fragment>()
        private val fragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            fragmentList.add(fragment)
            fragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return fragmentTitleList[position]
        }

    }*/

}
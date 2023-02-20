package com.example.bakku.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.bakku.R
import com.example.bakku.ViewPagerAdapter
import com.example.bakku.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var mBinding : FragmentHomeBinding? = null

    //slide view pager
    private lateinit var iv1:ImageView
    private lateinit var iv2:ImageView
    private lateinit var iv3:ImageView

    private lateinit var viewPager2: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentHomeBinding.inflate(inflater,container,false)
        mBinding = binding

        // fragment에서 findViewById 사용 (viewpager 부분)
        val v : View = inflater.inflate(R.layout.fragment_home,container,false)
        viewPager2 = v.findViewById(R.id.viewpager2)
        iv1 = v.findViewById(R.id.iv1)
        iv2 = v.findViewById(R.id.iv2)
        iv3 = v.findViewById(R.id.iv3)

        val images = listOf(R.drawable.img_1,R.drawable.img_2,R.drawable.img_3)
        val adapter = ViewPagerAdapter(images)
        viewPager2.adapter = adapter


        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                changeColor()
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)

            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                changeColor()
            }
        })

        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }

    fun changeColor() {
        when(viewPager2.currentItem){
            0->{
                /*iv1.setBackgroundColor(applicationContext.resources.getColor(R.color.active)
                        iv2.setBackgroundColor(applicationContext.resources.getColor(R.color.grey)
                        iv3.setBackgroundColor(applicationContext.resources.getColor(R.color.grey))*/
            }
            1->{
                /*iv1.setBackgroundColor(applicationContext.resources.getColor(R.color.grey)
                        iv2.setBackgroundColor(applicationContext.resources.getColor(R.color.active)
                        iv3.setBackgroundColor(applicationContext.resources.getColor(R.color.grey))*/
            }
            2->{
                /*iv1.setBackgroundColor(applicationContext.resources.getColor(R.color.grey)
                        iv2.setBackgroundColor(applicationContext.resources.getColor(R.color.grey)
                        iv3.setBackgroundColor(applicationContext.resources.getColor(R.color.active))*/
            }
        }
    }
}
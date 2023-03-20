package com.example.bakku.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bakku.R
import com.example.bakku.databinding.FragmentHomeSlide3Binding

class HomeSlide3Fragment : Fragment() {
    private var mBinding : FragmentHomeSlide3Binding? = null
    lateinit var frameLayout3 : FrameLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v : View = inflater.inflate(com.example.bakku.R.layout.fragment_home_slide3,container,false)

        frameLayout3 = v.findViewById(R.id.frameLayout3)
        frameLayout3.setOnClickListener{
            val fragment = EventFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.homeFragment,fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        //return mBinding?.root
        return v
    }
}
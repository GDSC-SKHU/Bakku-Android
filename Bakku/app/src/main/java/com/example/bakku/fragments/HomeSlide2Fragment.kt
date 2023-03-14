package com.example.bakku.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bakku.R
import com.example.bakku.databinding.FragmentHomeSlide2Binding

class HomeSlide2Fragment : Fragment() {
    private var mBinding : FragmentHomeSlide2Binding? = null
    lateinit var frameLayout2 : FrameLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v : View = inflater.inflate(com.example.bakku.R.layout.fragment_home_slide2,container,false)

        frameLayout2 = v.findViewById<FrameLayout>(R.id.frameLayout2)
        frameLayout2.setOnClickListener{
            Toast.makeText(context,"clicked", Toast.LENGTH_SHORT).show()
        }

        //return mBinding?.root
        return v
    }
}
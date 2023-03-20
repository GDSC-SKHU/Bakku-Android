package com.example.bakku.fragments

import android.app.Activity
import android.content.Intent
import com.example.bakku.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.bakku.databinding.FragmentHomeSlide1Binding
import com.example.bakku.presentation.EventActivity


class HomeSlide1Fragment : Fragment() {

    companion object {
        const val REQUEST_CODE = 1
    }

    //private var mBinding : FragmentHomeSlide1Binding? = null
    lateinit var frameLayout1 : FrameLayout


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
          savedInstanceState: Bundle?
    ): View? {
        val v : View = inflater.inflate(com.example.bakku.R.layout.fragment_home_slide1,container,false)

        frameLayout1 = v.findViewById(R.id.frameLayout1)
        frameLayout1.setOnClickListener{

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
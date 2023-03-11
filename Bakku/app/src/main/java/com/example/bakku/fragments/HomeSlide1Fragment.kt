package com.example.bakku.fragments

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bakku.databinding.FragmentHomeSlide1Binding



class HomeSlide1Fragment : Fragment() {

    private var mBinding : FragmentHomeSlide1Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeSlide1Binding.inflate(inflater,container,false)
        mBinding = binding
        return mBinding?.root
    }
}
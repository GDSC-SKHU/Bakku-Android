package com.example.bakku.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bakku.databinding.FragmentHomeSlide2Binding

class HomeSlide2Fragment : Fragment() {
    private var mBinding : FragmentHomeSlide2Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeSlide2Binding.inflate(inflater,container,false)
        mBinding = binding
        return mBinding?.root
    }
}
package com.example.bakku.fragments

import android.app.TabActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.bakku.R
import com.example.bakku.databinding.FragmentHomeBinding
import com.example.bakku.databinding.FragmentRankBinding

class RankFragment : Fragment() {

    private var mBinding : FragmentRankBinding? = null
    private lateinit var fragmentSea : Fragment
    private lateinit var frgmentAll : Fragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentRankBinding.inflate(inflater,container,false)
        mBinding = binding
        return mBinding?.root

        childFragmentManager.beginTransaction().replace(R.id.tabSea_rank,fragmentSea).commit()

        //fragment에서 findViewById 사용
        val v : View = inflater.inflate(R.layout.fragment_rank,container,false)

    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }
}
package com.example.bakku.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.bakku.R

class RankAllFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*val view = inflater.inflate(R.layout.fragment_rank_all, container, false)


        return view*/
        return inflater.inflate(R.layout.fragment_rank_all, container, false)

    }

}
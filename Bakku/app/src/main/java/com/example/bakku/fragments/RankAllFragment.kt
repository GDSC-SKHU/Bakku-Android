package com.example.bakku.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.bakku.R

class RankAllFragment : Fragment() {

    private lateinit var spinner: Spinner

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.rank_all_fragment, container, false)

        spinner = view.findViewById(R.id.sp_rank_all)

        val adapter = ArrayAdapter.createFromResource(requireContext(),
            R.array.rank_all, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        return view
    }

}
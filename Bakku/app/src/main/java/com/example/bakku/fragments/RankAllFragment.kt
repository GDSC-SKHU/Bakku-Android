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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.rank_all_fragment, container, false)
        /*val mySpinner = view.findViewById<Spinner>(R.id.my_spinner)

        // Spinner에 표시될 아이템을 배열로 정의합니다.
        val items = arrayOf("item1", "item2", "item3")

        // ArrayAdapter를 생성하여 Spinner에 아이템을 추가합니다.
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        mySpinner.adapter = adapter*/

        return view
    }

}
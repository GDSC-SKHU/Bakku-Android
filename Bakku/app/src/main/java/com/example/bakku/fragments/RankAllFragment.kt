package com.example.bakku.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.bakku.R

class RankAllFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.rank_all_fragment, container, false)


        // Argument 전달 받기
        val args = arguments
        val title = args?.getString("title")

        // 화면 설정
        val textView = view.findViewById<TextView>(R.id.textView)
        textView.text = title

        return view
    }

}
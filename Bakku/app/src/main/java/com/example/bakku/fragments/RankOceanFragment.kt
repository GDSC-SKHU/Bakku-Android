package com.example.bakku.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bakku.R

class RankOceanFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*val view = inflater.inflate(R.layout.fragment_rank_ocean, container, false)

        return view*/
        //return inflater.inflate(R.layout.fragment_rank_ocean, container, false)

        val rootView = inflater.inflate(R.layout.fragment_rank_ocean, container, false)
        val spinner: Spinner = rootView.findViewById(R.id.sp_rank_ocean)

        // Spinner에 들어갈 데이터
        val spinnerData = listOf("Item 1", "Item 2", "Item 3")

        // ArrayAdapter를 사용하여 Spinner에 데이터를 추가
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, spinnerData)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Spinner에서 아이템을 선택할 때의 동작
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // 선택된 아이템의 위치와 값을 가져옴
                val selectedItem = parent.getItemAtPosition(position).toString()
                Toast.makeText(requireContext(), selectedItem, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // 선택된 아이템이 없을 때의 동작
            }
        }

        return rootView
    }

}
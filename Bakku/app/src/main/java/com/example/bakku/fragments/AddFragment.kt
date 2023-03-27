package com.example.bakku.fragments

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import coil.load
import com.example.bakku.R
import com.example.bakku.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private lateinit var spinner: Spinner
    private lateinit var btn_before : AppCompatButton
    private lateinit var btn_after : AppCompatButton

    private var mBinding : FragmentAddBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // fragment UI 생성
        val v : View = inflater.inflate(R.layout.fragment_add,container,false)

        // Spinner 생성
        spinner = v.findViewById(R.id.sp_add_select_sea)

        // Spinner 아이템 추가
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.seas,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        // 사진 업로드
        btn_before = v.findViewById(R.id.btn_add_before)
        btn_before = v.findViewById(R.id.btn_add_after)

        return v
    }

}
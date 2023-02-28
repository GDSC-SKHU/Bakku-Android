package com.example.bakku.fragments

import android.Manifest
import android.content.Context
import android.media.Image
import android.os.Bundle
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

    private var mBinding : FragmentAddBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentAddBinding.inflate(inflater,container,false)
        mBinding = binding
        return mBinding?.root

        //fragment에서 findViewById 사용
        val v : View = inflater.inflate(R.layout.fragment_add,container,false)

        //spinner을 위한 adapter (바다 선택)
        var sData = resources.getStringArray(R.array.seas)
        val spinner = v.findViewById<Spinner>(R.id.sp_add_select_sea)
        val ct : Context = container!!.context
        var adapter = ArrayAdapter<String>(ct,android.R.layout.simple_spinner_item,sData)
        //requireContext() : Return the Context this fragment is currently associated with.
        spinner.adapter = adapter

        // 갤러리 업로드 리스너
        // 참고 코드 https://crazykim2.tistory.com/441
        var btnRep : AppCompatButton = v.findViewById(R.id.btn_add_rep)
        var ivRep : ImageView = v.findViewById(R.id.iv_add_rep)


    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }
}
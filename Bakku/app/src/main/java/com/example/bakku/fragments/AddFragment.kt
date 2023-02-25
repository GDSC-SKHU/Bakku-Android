package com.example.bakku.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.bakku.R
import com.example.bakku.databinding.FragmentAddBinding
import com.example.bakku.databinding.FragmentHomeBinding

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
        var sData = resources.getStringArray(R.array.sea)
        val spinner : Spinner = v.findViewById(R.id.sp_add_select_sea)
        var adapter = ArrayAdapter(requireContext(),R.layout.fragment_add,sData)
        //requireContext() : Return the Context this fragment is currently associated with.
        spinner.adapter = adapter
        /*

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                println("당신의 히어로는 " +list_of_items[position]+ "입니다.")
                //선택한 히어로의 요약을 출력한다.
                summary.text = list_of_summary[position];

                //끝에 상세보기 버튼을 하나 추가 하자. 그런데 이방법은 레이아웃에서 위치를 잡아 줘야 하는데 상당히 귀찮네...
                /*
                val button = Button(applicationContext)
                button.layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
                button.text = "상세보기"
                button.setOnClickListener {
                    println("상세보기 액티비티 열기")
                }
                constraintLayout.addView(button)
                 */
            }
        */

        // 아이템 선택 리스너
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                println("해수욕장을 선택하세요")
            }
            // https://taewooblog.tistory.com/127 스피너 현재 값 가져오는 법

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                TODO("Not yet implemented")
            }
        }
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }
}
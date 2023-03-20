package com.example.bakku.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bakku.R
import com.example.bakku.presentation.LoginActivity
import com.example.bakku.recyclerview.mypage.MypageModel
import com.example.bakku.recyclerview.mypage.MypageRecyclerAdapter
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class MypageFragment : Fragment() {

    // 데이터를 잠을 그릇 즉 배열에 MypageModel
    var modelList = ArrayList<MypageModel>()

    private lateinit var mypageRecyclerAdapter: MypageRecyclerAdapter
    private lateinit var my_recycler_view : RecyclerView

    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mypage , container, false)

        auth = FirebaseAuth.getInstance()
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this.requireContext(), gso)

        val logoutBtn = view.findViewById<Button>(R.id.mypage_logout)
        logoutBtn.setOnClickListener{
            auth.signOut()

            // Google sign out
            googleSignInClient.signOut().addOnCompleteListener() {
                //view.findNavController().navigate(R.id.activity_login)
                var intent = Intent(requireActivity(), LoginActivity::class.java)
                startActivity(intent)
            }
        }

        // 10번 반복
        for(i in 1 .. 10){
            var mypageModel = MypageModel(name = "성공회대학교", oceanImage = "https://news.samsungdisplay.com/wp-content/uploads/2022/05/IT_twi001t1345955-1-1024x639.jpg", date = "2023-03-12", weight = "10kg")
            this.modelList.add(mypageModel)
        }

        // 어탑터 인스턴스 생성
        mypageRecyclerAdapter = MypageRecyclerAdapter()
        mypageRecyclerAdapter.submitList(this.modelList)

        // 리사이클러뷰 설정
        my_recycler_view = view.findViewById(R.id.my_recycler_view)
        my_recycler_view.apply{
            // 리사이클러뷰 방향 등 설정
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            // 어답터 장착
            adapter = mypageRecyclerAdapter
        }

        return view
    }
}
package com.example.bakku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.bakku.databinding.ActivityMainBinding
import com.example.bakku.presentation.LoginActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {


    private lateinit var mBinding : ActivityMainBinding
    lateinit var toolbar : androidx.appcompat.widget.Toolbar
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mBinding.root)

        auth = FirebaseAuth.getInstance()

        // 네비게이션들을 담을 호스트
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.my_nav_host) as NavHostFragment

        //네비게이션 컨트롤러
        val navController = navHostFragment.navController

        //바텀 네비게이션 뷰와 네비게이션을 묶어준다
        NavigationUI.setupWithNavController(mBinding.myBottomNav,navController)


    }

    override fun onStart() {
        super.onStart()

        // 사용자가 로그인되어 있는지 확인
        val currentUser = auth.currentUser
        if (currentUser == null) {
            // 로그인되어 있지 않은 경우 로그인 Activity로 이동
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
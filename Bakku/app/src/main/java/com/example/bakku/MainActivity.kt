package com.example.bakku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.bakku.databinding.ActivityMainBinding
import com.example.bakku.fragments.RankFragment
import com.example.bakku.presentation.LoginActivity
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity()/*, NavigationView.OnNavigationItemSelectedListener*/ {

    //private var isNavigationOpen = false

    private lateinit var mBinding : ActivityMainBinding
    //lateinit var navigationView : NavigationView
    //lateinit var drawerLayout : DrawerLayout
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

        //setToolbar()

        //navigationDrawer
       /* navigationView = findViewById(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener(this)*/

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

    // 툴바 사용 설정
    /*private fun setToolbar(){
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // 툴바 왼쪽 버튼 설정
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)  // 왼쪽 버튼 사용 여부 true
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_baseline_dehaze_24)  // 왼쪽 버튼 이미지 설정
        supportActionBar!!.setDisplayShowTitleEnabled(false)    // 타이틀 안보이게 하기
    }

    // 툴바 메뉴 버튼을 설정
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)       // main_menu 메뉴를 toolbar 메뉴 버튼으로 설정
        return true
    }

    // 툴바 메뉴 버튼이 클릭 됐을 때 콜백
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // 클릭된 메뉴 아이템의 아이디 마다 when 구절로 클릭시 동작을 설정한다.
        when(item!!.itemId){
            android.R.id.home->{ // 메뉴 버튼
                drawerLayout = findViewById(R.id.drawerLayout)
                drawerLayout.openDrawer(GravityCompat.START)    // 네비게이션 드로어 열기
            }
           // R.id.hamberger-> Snackbar.make(toolbar,"Hamberger menu pressed",Snackbar.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }


    // 네비게이션 드로어 메뉴 클릭 리스너
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){  // 네비게이션 메뉴가 클릭되면 스낵바가 나타난다.
            R.id.nd_mypage->Snackbar.make(toolbar,"Navigation Mypage pressed",Snackbar.LENGTH_SHORT).show()
            R.id.nd_logout->Snackbar.make(toolbar,"Navigation Logout pressed",Snackbar.LENGTH_SHORT).show()
        }
        drawerLayout = findViewById(R.id.drawerLayout)
        drawerLayout.closeDrawers() // 기능을 수행하고 네비게이션을 닫아준다.
        return false
    }

    /*
     * 뒤로가기 버튼으로 네비게이션 닫기
     *
     * 네비게이션 드로어가 열려 있을 때 뒤로가기 버튼을 누르면 네비게이션을 닫고,
     * 닫혀 있다면 기존 뒤로가기 버튼으로 작동한다.
     */
    override fun onBackPressed() {
        drawerLayout = findViewById(R.id.drawerLayout)
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawers()
        }else{
            super.onBackPressed()
        }
    }*/


}
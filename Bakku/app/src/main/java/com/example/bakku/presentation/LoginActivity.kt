package com.example.bakku.presentation

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.example.bakku.MainActivity
import com.example.bakku.R
import com.example.bakku.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginActivity :AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    // firebase Auth
    private lateinit var auth : FirebaseAuth
    // google client
    private lateinit var googleSignInClient: GoogleSignInClient
    // private const val TAG = "GoogleActivity"
    private val RC_SIGN_IN = 99

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.btnLogin.setOnClickListener { clickBtn() }

        //Google 로그인 옵션 구성. requestIdToken 및 Email 요청
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            //'R.string.default_web_client_id' 에는 본인의 클라이언트 아이디를 넣어주면 됌
            //스트링을 따로 빼서 저렇게 사용했지만 스트링을 통째로 넣어도 됌
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        // firebase auth 객체
        auth = Firebase.auth
    }

    public override fun onStart() {
        super.onStart()

        /*val currentUser = auth.currentUser
        //updateUI(currentUser)
        if(currentUser != null){
            //reload()
        }*/
        val account = GoogleSignIn.getLastSignedInAccount(this)
        if(account!==null){ // 이미 로그인 되어있을시 바로 메인 액티비티로 이동
            toMainActivity(auth.currentUser)
        }
    }

    private fun clickBtn() {
        binding.btnLogin.setOnClickListener {
            //startActivity(Intent(this,MainActivity::class.java))
            BeginSignInRequest.builder().setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder().setSupported(true)
                    .setServerClientId(getString(R.string.web_client_id)).setFilterByAuthorizedAccounts(true)
                    .build()
            ).build()
        }
    }

    // toMainActivity
    fun toMainActivity(user: FirebaseUser?) {
        if(user !=null) { // MainActivity 로 이동
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

}


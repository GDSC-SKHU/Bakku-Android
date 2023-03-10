package com.example.bakku.presentation

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.bakku.MainActivity
import com.example.bakku.R
import com.example.bakku.databinding.ActivityLoginBinding


class LoginActivity :AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickBtn()

        /*var sData = resources.getStringArray(R.array.seas)
        val spinner = findViewById<Spinner>(R.id.sp_login_select_sea)
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,sData)
        spinner.adapter = adapter*/
    }

    private fun clickBtn() {
        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }

}
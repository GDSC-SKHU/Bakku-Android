package com.example.bakku.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bakku.databinding.ActivityBakkuDetailBinding


class BakkuDetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBakkuDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBakkuDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
package com.example.bakku.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bakku.databinding.ActivityEventBinding

class EventActivity : AppCompatActivity() {
    private lateinit var binding : ActivityEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
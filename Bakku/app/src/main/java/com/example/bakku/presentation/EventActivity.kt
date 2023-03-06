package com.example.bakku.presentation

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.bakku.R
import com.example.bakku.databinding.ActivityEventBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng

class EventActivity : AppCompatActivity() {
    private lateinit var binding : ActivityEventBinding
    lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mapView.onCreate(savedInstanceState)

        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mapView = findViewById(R.id.mv_event)
        
    }

    //맵이 로딩된 후 호출 될 함수
    fun onMapReady(googleMap: GoogleMap?) {
        val seoul = LatLng(37.566,126.978)
        googleMap?.moveCamera(CameraUpdateFactory.newLatLng(seoul))
        googleMap?.moveCamera(CameraUpdateFactory.zoomTo(10f))

    }

    override fun onStart() {
        mapView.onStart()
        super.onStart()
    }

    override fun onResume() {
        mapView.onResume()
        super.onResume()
    }

    override fun onPause() {
        mapView.onPause()
        super.onPause()
    }

    override fun onStop() {
        mapView.onStop()
        super.onStop()
    }

    override fun onDestroy() {
        mapView.onDestroy()
        super.onDestroy()
    }

    override fun onLowMemory() {
        mapView.onLowMemory()
        super.onLowMemory()
    }

}
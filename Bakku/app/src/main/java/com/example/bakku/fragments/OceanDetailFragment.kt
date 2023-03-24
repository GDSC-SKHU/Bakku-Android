package com.example.bakku.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bakku.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class OceanDetailFragment:Fragment(), OnMapReadyCallback {

    //구글맵
    lateinit var mapView: MapView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_ocean_detail,container,false)

        //구글맵
        mapView = v.findViewById(R.id.mv_ocean)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        return v
    }

    //구글맵
    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        // 맵이 준비되면 실행되는 콜백
        googleMap.addMarker(
            MarkerOptions()
                .position(LatLng(37.566535, 126.977969))
                .title("서울 시청")
        )
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(37.566535, 126.977969), 15f))
    }
}
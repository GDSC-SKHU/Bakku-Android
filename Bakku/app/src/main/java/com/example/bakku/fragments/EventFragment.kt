package com.example.bakku.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.bakku.R
import com.example.bakku.data.remote.response.EventResponse
import com.example.bakku.utils.ImageTransformer
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EventFragment: Fragment, OnMapReadyCallback {
    var mEvent : EventResponse

    //구글맵
    lateinit var mapView: MapView

    constructor(event: EventResponse): super() {
        mEvent = event
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_event,container,false)

        //구글맵
        mapView = v.findViewById(R.id.mv_event)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        // get tv_event_name
        val tvEventName = v.findViewById<TextView>(R.id.tv_event_name)
        tvEventName.setText(mEvent.name)

        // get tv_event_date
        val tvEventDate = v.findViewById<TextView>(R.id.tv_event_date)
        tvEventDate.setText(mEvent.startDate + " ~ " + mEvent.endDate)

        // get tv_event_describe
        val tvEventDescribe = v.findViewById<TextView>(R.id.tv_event_describe)
        tvEventDescribe.setText(mEvent.comment)

        // get iv_event
        val ivEvent = v.findViewById<ImageView>(R.id.iv_event)
        lifecycleScope.launch(Dispatchers.IO) {
            val bitmap = ImageTransformer.getImageBitmapFromUrl(mEvent.imageUrl)
            withContext(Dispatchers.Main) {
                ivEvent.setImageBitmap(bitmap)
            }
        }

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
                .position(LatLng(mEvent.latitude, mEvent.longitude))
                .title("속초 해수욕장")
        )
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(mEvent.latitude, mEvent.longitude), 15f))
    }
}
package com.example.bakku.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bakku.R
import com.example.bakku.recyclerview.bakkudetail.BakkuDetailModel
import com.example.bakku.recyclerview.bakkudetail.BakkuDetailRecyclerAdapter
import com.example.bakku.recyclerview.home.HomeBakkuModel
import com.example.bakku.recyclerview.home.HomeBakkuRecyclerAdapter
import com.example.bakku.recyclerview.home.HomeOceanRecyclerAdapter
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class OceanDetailFragment:Fragment(), OnMapReadyCallback {

    //구글맵
    lateinit var mapView: MapView
    var modelList = ArrayList<BakkuDetailModel>()

    private lateinit var bakkuDetailRecyclerAdapter: BakkuDetailRecyclerAdapter
    private lateinit var bakku_detail_recycler_view: RecyclerView

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

        //리사이클러뷰
        // 10번 반복
        for (i in 1..10) {
            var bakkuDetailModel = BakkuDetailModel(
                name = "성공회대학교",
                oceanImage = "https://news.samsungdisplay.com/wp-content/uploads/2022/05/IT_twi001t1345955-1-1024x639.jpg",
                date = "2023-03-12",
                weight = "10kg"
            )
            this.modelList.add(bakkuDetailModel)
        }

        // 어탑터 인스턴스 생성
        bakkuDetailRecyclerAdapter = BakkuDetailRecyclerAdapter()
        bakkuDetailRecyclerAdapter.submitList(this.modelList)

        // 리사이클러뷰 설정
        bakku_detail_recycler_view = v.findViewById(R.id.bakku_detail_recycler_view)
        bakku_detail_recycler_view.apply {
            // 리사이클러뷰 방향 등 설정
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            // 어답터 장착
            adapter = bakkuDetailRecyclerAdapter
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
                .position(LatLng(37.566535, 126.977969))
                .title("서울 시청")
        )
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(37.566535, 126.977969), 15f))
    }
}
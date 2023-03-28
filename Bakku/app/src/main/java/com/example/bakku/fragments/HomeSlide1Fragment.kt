package com.example.bakku.fragments

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.bakku.R
import com.example.bakku.data.remote.response.EventResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL


class HomeSlide1Fragment : Fragment {

    companion object {
        const val REQUEST_CODE = 1
    }

    //private var mBinding : FragmentHomeSlide1Binding? = null
    lateinit var frameLayout1 : FrameLayout
    lateinit var mEvent : EventResponse
//
    constructor(event: EventResponse) : super() {
        mEvent = event
        Log.d("HomeSlide1Fragment", mEvent.imageUrl?.let { Uri.parse(it) }.toString())
    }
    private suspend fun getImageBitmapFromUrl(url: String): Bitmap? = withContext(Dispatchers.IO) {
        try {
            val inputStream = URL(url).openStream()
            BitmapFactory.decodeStream(inputStream)
        } catch (e: Exception) {
            Log.e("Error", e.message!!)
            e.printStackTrace()
            null
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
          savedInstanceState: Bundle?
    ): View? {
        val v : View = inflater.inflate(com.example.bakku.R.layout.fragment_home_slide1,container,false)

        // change image src
        val imageView = v.findViewById<ImageView>(R.id.imgBanner1)

        lifecycleScope.launch(Dispatchers.IO) {
            val bitmap = getImageBitmapFromUrl(mEvent.imageUrl)
            withContext(Dispatchers.Main) {
                imageView.setImageBitmap(bitmap)
            }
        }

        frameLayout1 = v.findViewById(R.id.frameLayout1)
        frameLayout1.setOnClickListener{

            val fragment = EventFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.homeFragment,fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()

        }

        //return mBinding?.root
        return v
    }

}
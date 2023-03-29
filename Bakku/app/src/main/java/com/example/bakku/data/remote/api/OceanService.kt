package com.example.bakku.data.remote.api

import com.example.bakku.data.remote.response.OceanResponse
import com.example.bakku.data.remote.response.Paging
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OceanService {
    @GET("oceans")
    fun getOceans(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("size") size: Int = 100,
        @Query("page") page: Int = 0
    ): Call<Paging<OceanResponse>>
}
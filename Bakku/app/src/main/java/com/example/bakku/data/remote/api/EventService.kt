package com.example.bakku.data.remote.api

import com.example.bakku.data.remote.response.EventResponse
import com.example.bakku.data.remote.response.Paging
import retrofit2.Call
import retrofit2.http.GET


interface EventService {
    @GET("events")
    fun getEvents(): Call<Paging<EventResponse>>
}
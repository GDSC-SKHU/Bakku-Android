package com.example.bakku.data.remote.response

data class EventResponse (
    val id: Int,
    val name: String,
    val startDate: String,
    val endDate: String,
    val comment: String,
    val latitude: Double,
    val longitude: Double,
    val imageUrl: String,
    val createdDate: String,
    val modifiedDate: String
)
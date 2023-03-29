package com.example.bakku.data.remote.response

data class OceanResponse (
    val id: Int,
    val name: String,
    val comment: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val imageUrl: String,
    val createdDate: String,
    val modifiedDate: String
)
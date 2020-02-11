package com.dealer.toppopularfeatureapplication.module


import com.google.gson.annotations.SerializedName

data class Merchant(
    @SerializedName("average_rating")
    val averageRating: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("permalink")
    val permalink: String,
    @SerializedName("recommendation")
    val recommendation: Int,
    @SerializedName("recommendation_flag")
    val recommendationFlag: Boolean
)
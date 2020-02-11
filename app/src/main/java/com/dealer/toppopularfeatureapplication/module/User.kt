package com.dealer.toppopularfeatureapplication.module


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("current_dimes")
    val currentDimes: Int,
    @SerializedName("fpd_count")
    val fpdCount: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("karma")
    val karma: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("rank")
    val rank: String
)
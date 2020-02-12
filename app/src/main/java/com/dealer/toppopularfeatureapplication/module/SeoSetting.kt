package com.dealer.toppopularfeatureapplication.module


import com.google.gson.annotations.SerializedName

data class SeoSetting(
    @SerializedName("description")
    val description: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("web_url")
    val webUrl: String
)
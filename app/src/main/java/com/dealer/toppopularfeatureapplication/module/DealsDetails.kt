package com.dealer.toppopularfeatureapplication.module


import com.google.gson.annotations.SerializedName

data class DealsDetails(
    @SerializedName("deals")
    val deals: Deals,
    @SerializedName("seo_setting")
    val seoSetting: SeoSetting
)
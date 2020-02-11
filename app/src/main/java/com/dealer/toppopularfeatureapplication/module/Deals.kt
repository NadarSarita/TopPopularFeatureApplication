package com.dealer.toppopularfeatureapplication.module


import com.google.gson.annotations.SerializedName

data class Deals(
    @SerializedName("data")
    val dataValue : List<DataValue>,
    @SerializedName("total_count")
    val totalCount: Int
)
package com.dealer.toppopularfeatureapplication.module


import com.google.gson.annotations.SerializedName

data class Deals(
    val dataValue: List<DataValue>,
    @SerializedName("total_count")
    val totalCount: Int
)

package com.dealer.toppopularfeatureapplication.module


import com.google.gson.annotations.SerializedName

data class DataValue(
    @SerializedName("comments_count")
    val commentsCount: Int,
    @SerializedName("created_at")
    val createdAt: Long,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("vote_count")
    val voteCount: Int
)
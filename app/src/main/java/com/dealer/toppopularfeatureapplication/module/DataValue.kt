package com.dealer.toppopularfeatureapplication.module


import com.google.gson.annotations.SerializedName

data class DataValue(
    @SerializedName("all_posts_count")
    val allPostsCount: Int,
    @SerializedName("comments_count")
    val commentsCount: Int,
    @SerializedName("created_at")
    val createdAt: Long,
    @SerializedName("current_price")
    val currentPrice: Double,
    @SerializedName("deal_url")
    val dealUrl: String,
    val description: Any,
    @SerializedName("fpd_flag")
    val fpdFlag: Boolean,
    @SerializedName("fpd_suggestted")
    val fpdSuggestted: Boolean,
    @SerializedName("front_page_suggestions_count")
    val frontPageSuggestionsCount: Int,
    val id: Int,
    val image: String,
    @SerializedName("off_percent")
    val offPercent: String,
    @SerializedName("original_price")
    val originalPrice: Double,
    val score: Int,
    @SerializedName("share_url")
    val shareUrl: String,
    val state: String,
    val title: String,
    @SerializedName("view_count")
    val viewCount: Int,
    @SerializedName("vote_count")
    val voteCount: Int,
    @SerializedName("vote_value")
    val voteValue: Int
)
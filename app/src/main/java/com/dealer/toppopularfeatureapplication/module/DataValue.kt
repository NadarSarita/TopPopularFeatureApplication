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
    @SerializedName("description")
    val description: String,
    @SerializedName("fpd_flag")
    val fpdFlag: Boolean,
    @SerializedName("fpd_suggestted")
    val fpdSuggestted: Boolean,
    @SerializedName("front_page_suggestions_count")
    val frontPageSuggestionsCount: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("merchant")
    val merchant: Merchant,
    @SerializedName("off_percent")
    val offPercent: String,
    @SerializedName("original_price")
    val originalPrice: Double,
    @SerializedName("score")
    val score: Int,
    @SerializedName("share_url")
    val shareUrl: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("user")
    val user: User,
    @SerializedName("view_count")
    val viewCount: Int,
    @SerializedName("vote_count")
    val voteCount: Int,
    @SerializedName("vote_down_reason")
    val voteDownReason: VoteDownReason,
    @SerializedName("vote_value")
    val voteValue: Int
)
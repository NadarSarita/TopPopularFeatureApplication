package com.dealer.toppopularfeatureapplication.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "topDeals")
data class TopDeals(
    @PrimaryKey
    @ColumnInfo(name="id") var uid:Int,
    @ColumnInfo(name = "title") var title:String?,
    @ColumnInfo(name="image") var url:String?,
    var voteCount:Int?,
    var commentsCount:Int?,
    var createdAt:String?

)


package com.dealer.toppopularfeatureapplication.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "top_deals")
data class TopDeals(
    @PrimaryKey var uid:Int,
    @ColumnInfo(name = "title") var title:String?,
    @ColumnInfo(name="url") var url:String?
)

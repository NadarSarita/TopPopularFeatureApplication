package com.dealer.toppopularfeatureapplication.dao

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(TopDeals::class), version = 1)
abstract class AppDatabase : RoomDatabase(){
abstract fun topDealsDao():TopDealsDao
}

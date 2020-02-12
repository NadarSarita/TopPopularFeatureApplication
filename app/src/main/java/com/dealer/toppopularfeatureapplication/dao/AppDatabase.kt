package com.dealer.toppopularfeatureapplication.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = arrayOf(TopDeals::class), version = 1,exportSchema=false)
abstract class AppDatabase : RoomDatabase(){
abstract fun topDealsDao():TopDealsDao

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance
                    ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "Deals")
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                       /* val request = OneTimeWorkRequestBuilder<BackgroundDatabaseWorker>().build()
                        WorkManager.getInstance()?.enqueue(request)*/
                    }
                })
                .build()
        }
    }
}
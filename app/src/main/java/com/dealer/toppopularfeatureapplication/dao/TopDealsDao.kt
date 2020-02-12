package com.dealer.toppopularfeatureapplication.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dealer.toppopularfeatureapplication.module.DataValue

@Dao
interface TopDealsDao {

    @Insert
       // (onConflit= OnConflictStrategy.REPLACE)
    fun insertTopDeals(topDeals: List<DataValue>)

    @Query("SELECT * FROM top_deals")
    fun getTopDeals(): DataSource.Factory<Int, DataValue>
}

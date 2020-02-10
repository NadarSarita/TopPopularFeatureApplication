package com.dealer.toppopularfeatureapplication.top_deals

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dealer.toppopularfeatureapplication.module.DataValue

class DealsDataSourceFactory : DataSource.Factory<Int, DataValue>() {
    val userLiveDataSource = MutableLiveData<DealsDataSource>()
    override fun create(): DataSource<Int, DataValue> {
        val userDataSource = DealsDataSource()
        userLiveDataSource.postValue(userDataSource)
        return userDataSource
    }
}
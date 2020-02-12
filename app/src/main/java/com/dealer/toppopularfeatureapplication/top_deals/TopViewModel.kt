package com.dealer.toppopularfeatureapplication.top_deals

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dealer.toppopularfeatureapplication.dao.AppDatabase
import com.dealer.toppopularfeatureapplication.dao.TopDealsDao
import com.dealer.toppopularfeatureapplication.module.DataValue

class TopViewModel constructor(application: Application): AndroidViewModel(application) {
    var userPagedList: LiveData<PagedList<DataValue>>
    val userLiveDataSource = MutableLiveData<DealsDataSource>()
    init {

        val itemDataSourceFactory = AppDatabase.getInstance(getApplication()).topDealsDao().getTopDeals()
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(DealsDataSource.PAGE_SIZE)
            .build()
        userPagedList = LivePagedListBuilder(itemDataSourceFactory, config).build()
    }
}
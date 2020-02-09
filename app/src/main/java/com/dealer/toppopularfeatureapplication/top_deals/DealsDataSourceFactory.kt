package com.dealer.toppopularfeatureapplication.top_deals

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dealer.toppopularfeatureapplication.module.DataValue
import com.dealer.toppopularfeatureapplication.network.DealsInterface
import io.reactivex.disposables.CompositeDisposable

class DealsDataSourceFactory (private val apiService:DealsInterface, private val compositeDisposable: CompositeDisposable)
    : DataSource.Factory<Int,DataValue>(){

     val dealsLiveDataSource = MutableLiveData<DealsDataSource>()
    override fun create():DataSource<Int,DataValue>{
        val dealsDataSource= DealsDataSource(apiService, compositeDisposable)

        dealsLiveDataSource.postValue(dealsDataSource)

        return dealsDataSource
    }

}
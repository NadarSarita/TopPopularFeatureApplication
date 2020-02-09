package com.dealer.toppopularfeatureapplication.top_deals

import android.provider.ContactsContract
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.dealer.toppopularfeatureapplication.module.DataValue
import com.dealer.toppopularfeatureapplication.network.DealsInterface
import com.dealer.toppopularfeatureapplication.network.PAGE
import com.dealer.toppopularfeatureapplication.repository.NetworkState
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DealsDataSource(private val apiService: DealsInterface, private val compositeDisposable: CompositeDisposable) : PageKeyedDataSource<Int, DataValue>(){

    private var page= PAGE
    val networkState:MutableLiveData<NetworkState> =MutableLiveData()

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, DataValue>) {
    networkState.postValue(NetworkState.LOADING)

        compositeDisposable.add(apiService.getTop(page)
            .subscribeOn(Schedulers.io())
            .subscribe({
                callback.onResult(it.deals.dataValue,null,page+1)
                println("Working dataSource ${it.deals.totalCount}")
                networkState.postValue(NetworkState.LOADED)
            },
                {
                    networkState.postValue(NetworkState.ERROR)
                    Log.i("DealsDataSource",it.message)
                }))
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, DataValue>) {
        networkState.postValue(NetworkState.LOADING)
        compositeDisposable.add(apiService.getTop(params.key)
            .subscribeOn(Schedulers.io())
            .subscribe({
                if(it.deals.totalCount>=params.key)
                {
                    callback.onResult(it.deals.dataValue,params.key+1)
                    networkState.postValue(NetworkState.LOADED)
                }else{
                    networkState.postValue(NetworkState.END)
                }
                networkState.postValue(NetworkState.LOADED)
            },
                {
                    networkState.postValue(NetworkState.ERROR)
                    Log.i("DealsDataSource",it.message)
                }))
   }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, DataValue>) {

    }


}
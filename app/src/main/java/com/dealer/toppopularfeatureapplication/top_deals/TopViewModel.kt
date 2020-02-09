package com.dealer.toppopularfeatureapplication.top_deals

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dealer.toppopularfeatureapplication.module.DataValue
import com.dealer.toppopularfeatureapplication.repository.NetworkState
import io.reactivex.disposables.CompositeDisposable

class TopViewModel(private val dealsRepository: DealsPagedListRepository): ViewModel() {
    private val compositeDisposable=CompositeDisposable()

    val dealPagedList: LiveData<PagedList<DataValue>> by lazy {
        dealsRepository.fetchLiveDealsPagedList(compositeDisposable)
    }

    val networkState:LiveData<NetworkState> by lazy{
        dealsRepository.getNetworkState()
    }

    fun listIsEmpty():Boolean{
        return dealPagedList.value?.isEmpty()?:true
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
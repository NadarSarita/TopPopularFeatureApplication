package com.dealer.toppopularfeatureapplication

/*
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dealer.toppopularfeatureapplication.repository.NetworkState
import io.reactivex.disposables.CompositeDisposable

class SingleDealsViewModel(private val dealsDetailsRepository: DealsDetailsRepository) :ViewModel(){
    private val compositeDisposable=CompositeDisposable()

    val dealsDetails:LiveData<DealsDetails> by lazy {
        dealsDetailsRepository.fetchSingleDealsDetails(compositeDisposable)
    }

    val networkState:LiveData<NetworkState> by lazy {
        dealsDetailsRepository.getDealsDetailNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}*/

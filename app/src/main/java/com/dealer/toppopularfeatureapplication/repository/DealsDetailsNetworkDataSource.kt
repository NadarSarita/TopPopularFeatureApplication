package com.dealer.toppopularfeatureapplication.repository

/*

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dealer.toppopularfeatureapplication.network.DealsInterface
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

class DealsDetailsNetworkDataSource(private val apiService:DealsInterface, private val compositeDisposable: CompositeDisposable) {

    private val _networkState=MutableLiveData<NetworkState>()
    val networkState= LiveData<NetworkState>
    get()=_networkState

    private val _dealsDetailsResponse=MutableLiveData<DealsDetails>()
    val dealsDetailsResponse: LiveData<DealsDetails>
    get() = _dealsDetailsResponse

    fun fetchDealsDetails()
    {
        _networkState.postValue(NetworkState.LOADING)

        try {
            compositeDisposable.add(
                apiService.getTop()
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        _dealsDetailsResponse.postValue(it)
                        _networkState.postValue(NetworkState.LOADED)
                    },
                        {
                            _networkState.postValue(NetworkState.ERROR)
                            Log.e("DealsDataSource",it.message)
                        })
            )
        }
        catch (e:Exception){
            Log.e("DealsDataSource",e.message)
        }
    }
}*/

package com.dealer.toppopularfeatureapplication.top_deals

/*
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dealer.toppopularfeatureapplication.module.DataValue
import com.dealer.toppopularfeatureapplication.network.DealsInterface
import com.dealer.toppopularfeatureapplication.network.PER_PAGE
import com.dealer.toppopularfeatureapplication.repository.NetworkState
import io.reactivex.disposables.CompositeDisposable

class DealsPagedListRepository(private val apiService: DealsInterface) {
    lateinit var dealsPagedList:LiveData<PagedList<DataValue>>
    lateinit var dealsDataSourceFactory: DealsDataSourceFactory

    fun fetchLiveDealsPagedList(compositeDisposable: CompositeDisposable):LiveData<PagedList<DataValue>>{
        dealsDataSourceFactory= DealsDataSourceFactory(apiService, compositeDisposable)

        val config: PagedList.Config= PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(PER_PAGE)
            .setPageSize(PER_PAGE)
            .build()

        dealsPagedList= LivePagedListBuilder(dealsDataSourceFactory, config).build()
        println("Repository working ${dealsPagedList.value}")
        return dealsPagedList
    }

    fun getNetworkState():LiveData<NetworkState>{
        return Transformations.switchMap<DealsDataSource,NetworkState>(dealsDataSourceFactory.dealsLiveDataSource,
            DealsDataSource::networkState)
    }

}*/

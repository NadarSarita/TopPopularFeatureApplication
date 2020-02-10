package com.dealer.toppopularfeatureapplication.top_deals

import androidx.paging.PageKeyedDataSource
import com.dealer.toppopularfeatureapplication.module.DataValue
import com.dealer.toppopularfeatureapplication.module.Deals
import com.dealer.toppopularfeatureapplication.network.DealsDBClient
import com.dealer.toppopularfeatureapplication.network.DealsInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DealsDataSource : PageKeyedDataSource<Int, DataValue>() {
    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, DataValue>) {
        val service = DealsDBClient.buildService(DealsInterface::class.java)
        val call = service.getTop(params.key)
        call.enqueue(object : Callback<Deals> {
            override fun onResponse(call: Call<Deals>, response: Response<Deals>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.dataValue
                    val key = if (params.key > 1) params.key - 1 else 0
                    responseItems?.let {
                        callback.onResult(responseItems, key)
                    }
                }
            }
            override fun onFailure(call: Call<Deals>, t: Throwable) {
            }
        })
    }
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, DataValue>) {
        val service = DealsDBClient.buildService(DealsInterface::class.java)
        val call = service.getTop(FIRST_PAGE)
        call.enqueue(object : Callback<Deals> {
            override fun onResponse(call: Call<Deals>, response: Response<Deals>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.dataValue
                    responseItems?.let {
                        callback.onResult(responseItems, null, FIRST_PAGE + 1)
                    }
                }
            }
            override fun onFailure(call: Call<Deals>, t: Throwable) {
            }
        })
    }
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, DataValue>) {
        val service = DealsDBClient.buildService(DealsInterface::class.java)
        val call = service.getTop(params.key)
        call.enqueue(object : Callback<Deals> {
            override fun onResponse(call: Call<Deals>, response: Response<Deals>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.dataValue
                    val key = params.key + 1
                    responseItems?.let {
                        callback.onResult(responseItems, key)
                    }
                }
            }
            override fun onFailure(call: Call<Deals>, t: Throwable) {
            }
        })
    }
    companion object {
        const val PAGE_SIZE = 10
        const val FIRST_PAGE = 1
    }
}
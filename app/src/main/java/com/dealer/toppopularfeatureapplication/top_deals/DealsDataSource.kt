package com.dealer.toppopularfeatureapplication.top_deals

import androidx.paging.PageKeyedDataSource
import com.dealer.toppopularfeatureapplication.module.DataValue
import com.dealer.toppopularfeatureapplication.module.DealsDetails
import com.dealer.toppopularfeatureapplication.network.DealsDBClient
import com.dealer.toppopularfeatureapplication.network.DealsInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DealsDataSource : PageKeyedDataSource<Int, DataValue>() {
    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, DataValue>) {
        val service = DealsDBClient.buildService(DealsInterface::class.java)
        val call = service.getTop(params.key)
        call.enqueue(object : Callback<DealsDetails> {
            override fun onResponse(call: Call<DealsDetails>, response: Response<DealsDetails>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.deals.dataValue
                    println("Response ${responseItems.size}")
                    val key = if (params.key > 1) params.key - 1 else 0
                    responseItems?.let {
                        callback.onResult(responseItems, key)
                    }
                }
                else{
                    println("No Response")
                }
            }
            override fun onFailure(call: Call<DealsDetails>, t: Throwable) {
                println("No Response ${t.message}")
            }
        })
    }
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, DataValue>) {
        val service = DealsDBClient.buildService(DealsInterface::class.java)
        val call = service.getTop(FIRST_PAGE)
        call.enqueue(object : Callback<DealsDetails> {
            override fun onResponse(call: Call<DealsDetails>, response: Response<DealsDetails>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.deals.dataValue
                    println("Response ${responseItems.size}")
                    responseItems?.let {
                        callback.onResult(responseItems, null, FIRST_PAGE + 1)
                    }
                }
                else{
                    println("No Response")
                }
            }
            override fun onFailure(call: Call<DealsDetails>, t: Throwable) {
                println("No Response ${t.message}")
            }
        })
    }
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, DataValue>) {
        val service = DealsDBClient.buildService(DealsInterface::class.java)
        val call = service.getTop(params.key)
        call.enqueue(object : Callback<DealsDetails> {
            override fun onResponse(call: Call<DealsDetails>, response: Response<DealsDetails>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.deals.dataValue
                    println("Response ${responseItems.size}")
                    val key = params.key + 1
                    responseItems?.let {
                        callback.onResult(responseItems, key)
                    }
                }
                else{
                    println("No Response")
                }
            }
            override fun onFailure(call: Call<DealsDetails>, t: Throwable) {
                println("No Response ${t.message}")
            }
        })
    }
    companion object {
        const val PAGE_SIZE = 10
        const val FIRST_PAGE = 1
    }
}
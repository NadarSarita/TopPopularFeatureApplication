package com.dealer.toppopularfeatureapplication.network

import com.dealer.toppopularfeatureapplication.module.Deals
import com.dealer.toppopularfeatureapplication.module.DealsDetails
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface DealsInterface {

    @GET("top.json")
    fun getTop(@Query("page") page:Int): Single<DealsDetails>

    @GET("popular.json")
    fun getPopular(): Single<Deals>

    @GET("featured.json")
    fun getFeatured(): Single<Deals>


}
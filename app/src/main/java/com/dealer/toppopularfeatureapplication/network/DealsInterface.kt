package com.dealer.toppopularfeatureapplication.network

import com.dealer.toppopularfeatureapplication.module.Deals
import com.dealer.toppopularfeatureapplication.module.DealsDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface DealsInterface {

    @Headers("X-Desidime-Client:68045fd226ab32029c98bf4533bfa98b3c50423094d292d70ca2702e61a9679b")
    @GET("top.json")
    fun getTop(@Query("page") page:Int): Call<DealsDetails>

    @Headers("X-Desidime-Client:68045fd226ab32029c98bf4533bfa98b3c50423094d292d70ca2702e61a9679b")
    @GET("popular.json")
    fun getPopular(@Query("page") page:Int): Call<Deals>

    @Headers("X-Desidime-Client:68045fd226ab32029c98bf4533bfa98b3c50423094d292d70ca2702e61a9679b")
    @GET("featured.json")
    fun getFeatured(@Query("page") page:Int): Call<Deals>


}
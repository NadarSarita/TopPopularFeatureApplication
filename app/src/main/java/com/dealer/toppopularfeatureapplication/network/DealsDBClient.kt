package com.dealer.toppopularfeatureapplication.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val PAGE=1
const val PER_PAGE=10

const val BASE_URL="https://stagingapi.desidime.com/v3/deals/"
const val DESIDIME_CLIENT="68045fd226ab32029c98bf4533bfa98b3c50423094d292d70ca2702e61a9679b"
object DealsDBClient {
    fun getClient(): DealsInterface{
        val requestInterceptor= Interceptor{
            val url=it.request().url().newBuilder().build()

            val request=it.request().newBuilder().url(url).addHeader("X-Desidime-Client",DESIDIME_CLIENT).build()

            return@Interceptor it.proceed(request)
        }

        val okHttpClient:OkHttpClient =OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .connectTimeout(60,TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DealsInterface::class.java)
    }
}
package com.dealer.toppopularfeatureapplication.network

import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




object DealsDBClient {
    // Base URL
    const val BASE_URL="https://stagingapi.desidime.com/v3/deals/"
    val DISK_CACHE_SIZE = 10 * 1024 * 1024 // 10 MB

    // Create Logger
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


    // Create OkHttp Client
    private val okHttp = OkHttpClient.Builder()
        .addInterceptor(logger)


    // Create Retrofit Builder
    private val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())


    // Create Retrofit Instance
    private val retrofit = builder.build()
    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }

}
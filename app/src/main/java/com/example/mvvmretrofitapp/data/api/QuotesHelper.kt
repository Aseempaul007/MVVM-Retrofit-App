package com.example.mvvmretrofitapp.data.api

import com.example.mvvmretrofitapp.data.api.quoteinterface.QuoteApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object QuotesHelper {

    private val BASE_URL = "https://quotable.io"

    fun getRetrofitInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}
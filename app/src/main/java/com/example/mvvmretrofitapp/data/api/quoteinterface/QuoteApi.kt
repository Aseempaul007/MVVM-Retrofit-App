package com.example.mvvmretrofitapp.data.api.quoteinterface

import com.example.mvvmretrofitapp.data.api.model.Quote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface QuoteApi {
    // https://quotable.io/quotes?page=1
    @GET("/quotes")
    suspend fun getQuotes(
        @Query("page")
        page: Int
    ): Response<Quote>
}

// BASE_URL+quotes?page=1
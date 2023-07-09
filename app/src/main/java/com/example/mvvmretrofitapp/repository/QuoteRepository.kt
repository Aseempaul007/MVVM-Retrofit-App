package com.example.mvvmretrofitapp.repository

import com.example.mvvmretrofitapp.data.api.model.Quote
import com.example.mvvmretrofitapp.data.api.quoteinterface.QuoteApi
import retrofit2.Response

class QuoteRepository(private val quoteApi: QuoteApi) {

    suspend fun getQuotes(page: Int): Response<Quote> {
        return quoteApi.getQuotes(page)
    }
}
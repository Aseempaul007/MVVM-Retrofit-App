package com.example.mvvmretrofitapp.repository

import com.example.mvvmretrofitapp.data.api.model.Quote
import com.example.mvvmretrofitapp.data.api.quoteinterface.QuoteApi
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Response
import javax.inject.Inject


class QuoteRepository @Inject constructor(private val quoteApi: QuoteApi) {

    suspend fun getQuotes(page: Int): Response<Quote> {
        return quoteApi.getQuotes(page)
    }
}
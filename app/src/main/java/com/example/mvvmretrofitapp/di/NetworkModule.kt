package com.example.mvvmretrofitapp.di

import android.app.Application
import com.example.mvvmretrofitapp.data.api.QuotesHelper
import com.example.mvvmretrofitapp.data.api.quoteinterface.QuoteApi
import com.example.mvvmretrofitapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun getRetrofitInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun getQuoteApi(retrofit: Retrofit): QuoteApi{
        return retrofit.create(QuoteApi::class.java)
    }
}
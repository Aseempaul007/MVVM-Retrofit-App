package com.example.mvvmretrofitapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmretrofitapp.data.api.model.Quote
import com.example.mvvmretrofitapp.repository.QuoteRepository

class MainViewModel(private val quoteRepository: QuoteRepository): ViewModel() {

    var quotesLiveData = MutableLiveData<Quote>()

    suspend fun getQuotes(page: Int){
        val result = quoteRepository.getQuotes(page)
        if(result.body() !=null){
            quotesLiveData.postValue(result.body())
        }
    }
}
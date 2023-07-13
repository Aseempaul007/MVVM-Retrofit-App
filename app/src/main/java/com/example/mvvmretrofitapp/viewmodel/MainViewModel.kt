package com.example.mvvmretrofitapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmretrofitapp.data.api.model.Quote
import com.example.mvvmretrofitapp.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val quoteRepository: QuoteRepository): ViewModel() {

    var quotesLiveData = MutableLiveData<Quote>()

    suspend fun getQuotes(page: Int){
        val result = quoteRepository.getQuotes(page)
        if(result.body() !=null){
            quotesLiveData.postValue(result.body())
        }
    }
}
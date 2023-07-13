package com.example.mvvmretrofitapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmretrofitapp.R
import com.example.mvvmretrofitapp.data.api.QuotesHelper
import com.example.mvvmretrofitapp.data.api.model.Quote
import com.example.mvvmretrofitapp.data.api.quoteinterface.QuoteApi
import com.example.mvvmretrofitapp.databinding.ActivityMainBinding
import com.example.mvvmretrofitapp.repository.QuoteRepository
import com.example.mvvmretrofitapp.util.Constants.MY_TAG
import com.example.mvvmretrofitapp.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var quoteRepository: QuoteRepository
    @Inject
    lateinit var quoteApi: QuoteApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainViewModel= ViewModelProvider(this).get(MainViewModel::class.java)

        CoroutineScope(Dispatchers.IO).launch{
            mainViewModel.getQuotes(1)
        }

        mainViewModel.quotesLiveData.observe(this, Observer {
            Log.d(MY_TAG,it.results.toString())
        })
    }
}
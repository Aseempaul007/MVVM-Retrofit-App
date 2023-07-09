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
import com.example.mvvmretrofitapp.viewmodel.MainViewModel
import com.example.mvvmretrofitapp.viewmodel.MainViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.create

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var quoteRepository: QuoteRepository
    lateinit var quoteApi: QuoteApi
    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        quoteApi = QuotesHelper.getRetrofitInstance().create(QuoteApi::class.java)
        quoteRepository = QuoteRepository(quoteApi)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(quoteRepository)).get(MainViewModel::class.java)

        CoroutineScope(Dispatchers.IO).launch{
            mainViewModel.getQuotes(1)

        }

        mainViewModel.quotesLiveData.observe(this, Observer {
            Log.d("TAG",it.results.toString())
        })



    }
}
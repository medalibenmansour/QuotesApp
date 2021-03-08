package com.daly.quotesapp.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.daly.quotesapp.databinding.ActivityMainBinding
import com.daly.quotesapp.presentation.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModel<MainViewModel>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = mainViewModel
        mainViewModel.fetchRandomQuoteLiveData.observe(this, Observer { // observing response from viewmodel
            binding.quote.text = String.format("%s \n\n-%s \n\nid:%s", it.quote, it.author, it.quote_id)
        })

        mainViewModel.errorLiveData.observe(this, Observer { // observing exception message from viewmodel
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

    }

//    override fun onResume() {
//        super.onResume()
//        mainViewModel.fetchQuoteFromServer()
//    }
}
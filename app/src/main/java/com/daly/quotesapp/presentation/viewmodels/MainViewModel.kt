package com.daly.quotesapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daly.quotesapp.data.network.models.RandomQuoteResponse
import com.daly.quotesapp.data.repositories.IRepository
import com.daly.quotesapp.utils.ApiException
import com.daly.quotesapp.utils.NoInternetException
import kotlinx.coroutines.launch

class MainViewModel(private val iRepository: IRepository) : ViewModel() {

    private val _errorLiveData: MutableLiveData<String> = MutableLiveData()
    val errorLiveData: LiveData<String>
        get() = _errorLiveData

    private val _fetchRandomQuoteLiveData: MutableLiveData<RandomQuoteResponse> = MutableLiveData()
    val fetchRandomQuoteLiveData: LiveData<RandomQuoteResponse>
        get() = _fetchRandomQuoteLiveData


    fun fetchQuoteFromServer() = viewModelScope.launch {
        try {
            _fetchRandomQuoteLiveData.value = iRepository.fetchRandomQuote()
        } catch (e: ApiException) {
            _errorLiveData.value = e.message
        } catch (e: NoInternetException) {
            _errorLiveData.value = e.message
        } catch (e: Exception) {
            _errorLiveData.value = e.message
        }
    }

    fun addQuoteToDB() = viewModelScope.launch {
        val randomQuote = _fetchRandomQuoteLiveData.value
        if (randomQuote != null) {
            iRepository.addQuoteToDB(randomQuote)
            _errorLiveData.value = "Saved to database"
        } else {
            _errorLiveData.value = "No Quote available to save."
        }
    }
}
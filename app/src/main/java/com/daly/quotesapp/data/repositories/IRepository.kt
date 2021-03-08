package com.daly.quotesapp.data.repositories

import com.daly.quotesapp.data.network.models.FetchTodo
import com.daly.quotesapp.data.network.models.PostQuoteRequest
import com.daly.quotesapp.data.network.models.PostQuoteResponse
import com.daly.quotesapp.data.network.models.RandomQuoteResponse

interface IRepository {

    suspend fun fetchRandomQuote(): RandomQuoteResponse
    suspend fun uploadQuote(updateQuoteRequest: PostQuoteRequest): PostQuoteResponse

    suspend fun fetchToDo(): FetchTodo

    suspend fun addQuoteToDB(quote: RandomQuoteResponse)

}
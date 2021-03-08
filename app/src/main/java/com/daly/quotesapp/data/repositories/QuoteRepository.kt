package com.daly.quotesapp.data.repositories

import com.daly.quotesapp.data.db.dao.QuoteDao
import com.daly.quotesapp.data.network.SafeApiRequestWrapper
import com.daly.quotesapp.data.network.factories.IApiFactory
import com.daly.quotesapp.data.network.models.FetchTodo
import com.daly.quotesapp.data.network.models.PostQuoteRequest
import com.daly.quotesapp.data.network.models.PostQuoteResponse
import com.daly.quotesapp.data.network.models.RandomQuoteResponse
import com.daly.quotesapp.utils.toQuoteEntity

class QuoteRepository(
    private val apiClientFactory: IApiFactory,
    private val dao: QuoteDao
) : IRepository, SafeApiRequestWrapper() {

    override suspend fun fetchRandomQuote(): RandomQuoteResponse {
        return makeSafeRequest { apiClientFactory.client.fetchRandomQuote() }
    }

    override suspend fun uploadQuote(updateQuoteRequest: PostQuoteRequest): PostQuoteResponse {
        return makeSafeRequest { apiClientFactory.client.uploadQuote(updateQuoteRequest) }
    }

    override suspend fun fetchToDo(): FetchTodo {
        return makeSafeRequest { apiClientFactory.clientSecond.fetchToDo() }
    }

    override suspend fun addQuoteToDB(quote: RandomQuoteResponse) {
        dao.addQuote(quote.toQuoteEntity())
    }
}
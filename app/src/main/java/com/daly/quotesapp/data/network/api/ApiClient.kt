package com.daly.quotesapp.data.network.api

import com.daly.quotesapp.data.network.models.PostQuoteRequest
import com.daly.quotesapp.data.network.models.PostQuoteResponse
import com.daly.quotesapp.data.network.models.RandomQuoteResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiClient {

    @GET("get-random-quote")
    suspend fun fetchRandomQuote(): Response<RandomQuoteResponse>

    @POST("create-quote")
    suspend fun uploadQuote(@Body updateQuoteRequest: PostQuoteRequest): Response<PostQuoteResponse>
}
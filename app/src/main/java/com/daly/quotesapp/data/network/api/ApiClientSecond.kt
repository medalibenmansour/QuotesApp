package com.daly.quotesapp.data.network.api

import com.daly.quotesapp.data.network.models.FetchTodo
import retrofit2.Response
import retrofit2.http.GET

interface ApiClientSecond {

    @GET("/todos/1")
    suspend fun fetchToDo(): Response<FetchTodo>
}
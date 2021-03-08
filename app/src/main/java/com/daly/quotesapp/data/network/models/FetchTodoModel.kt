package com.daly.quotesapp.data.network.models

import com.google.gson.annotations.SerializedName

data class FetchTodo(
    @SerializedName("userId") val userId: Int?,
    @SerializedName("id") val id: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("completed") val completed: Boolean?
)


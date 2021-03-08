package com.daly.quotesapp.data.network.models

import com.google.gson.annotations.SerializedName

data class PostQuoteRequest(
    @SerializedName("quote") val quote: String,
    @SerializedName("author") val author: String
)

data class PostQuoteResponse(
    @SerializedName("message") val message: String?,
    @SerializedName("quote_id") val quote_id: Int?
)
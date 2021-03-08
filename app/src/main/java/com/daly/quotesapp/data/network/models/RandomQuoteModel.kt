package com.daly.quotesapp.data.network.models

import com.google.gson.annotations.SerializedName

data class RandomQuoteResponse(
    @SerializedName("author") val author: String?,
    @SerializedName("quote") val quote: String?,
    @SerializedName("quote_id") val quote_id: Int?
)
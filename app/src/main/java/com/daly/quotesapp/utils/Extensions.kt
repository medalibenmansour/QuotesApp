package com.daly.quotesapp.utils

import com.daly.quotesapp.data.db.entities.QuoteEntity
import com.daly.quotesapp.data.network.models.RandomQuoteResponse

fun RandomQuoteResponse.toQuoteEntity(): QuoteEntity {
    return QuoteEntity(this.quote_id, this.quote, this.author)
}
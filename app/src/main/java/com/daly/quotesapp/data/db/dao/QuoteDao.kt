package com.daly.quotesapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.daly.quotesapp.data.db.entities.QuoteEntity

@Dao
interface QuoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuote(quoteEntity: QuoteEntity)

}
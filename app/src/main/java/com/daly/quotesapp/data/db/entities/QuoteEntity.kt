package com.daly.quotesapp.data.db.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotes")
class QuoteEntity(
    @ColumnInfo(name = "quote_id") @PrimaryKey @NonNull val quote_id: Int?,
    @ColumnInfo(name = "message") val message: String?,
    @ColumnInfo(name = "author") val author: String?
)
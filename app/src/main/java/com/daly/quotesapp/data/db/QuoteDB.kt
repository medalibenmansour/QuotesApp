package com.daly.quotesapp.data.db

import android.content.Context
import android.os.Environment
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.daly.quotesapp.data.db.dao.QuoteDao
import com.daly.quotesapp.data.db.entities.QuoteEntity

private const val PRIVATE_DATABASE_NAME = "quotes.db"
private val PUBLIC_DATABASE_NAME = Environment.getExternalStorageDirectory().toString() + "/quotes.db"

@Database(
    entities = [QuoteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class QuoteDB : RoomDatabase() {

    abstract fun dao(): QuoteDao

    companion object {

        @Volatile
        private var INSTANCE: QuoteDB? = null

        fun getDatabase(context: Context): QuoteDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuoteDB::class.java,
                    PRIVATE_DATABASE_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}
package com.daly.quotesapp

import android.app.Application
import com.daly.quotesapp.di.networkModule
import com.daly.quotesapp.di.viewModelsModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class QuotesApplication : Application() {

    companion object {
        lateinit var instance: QuotesApplication
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@QuotesApplication)
            modules(listOf(networkModule, viewModelsModule))
        }

        Stetho.initializeWithDefaults(this)
    }
}
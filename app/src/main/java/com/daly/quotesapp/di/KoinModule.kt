package com.daly.quotesapp.di

import com.daly.quotesapp.data.db.QuoteDB
import com.daly.quotesapp.data.db.dao.QuoteDao
import com.daly.quotesapp.data.network.factories.ApiClientFactory
import com.daly.quotesapp.data.network.factories.IApiFactory
import com.daly.quotesapp.data.network.interceptors.NetworkConnectionInterceptor
import com.daly.quotesapp.data.repositories.IRepository
import com.daly.quotesapp.data.repositories.QuoteRepository
import com.daly.quotesapp.presentation.viewmodels.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule = module(override = true) {
    single { NetworkConnectionInterceptor(androidContext()) }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }
    single(named("secondInstance")) { provideRetrofitSecondInstance(get()) }

    single<IApiFactory> { ApiClientFactory(get(), get()) }
    single<QuoteDao> { QuoteDB.getDatabase(androidContext()).dao() }
    single<IRepository> { QuoteRepository(get(), get()) }
}

val viewModelsModule = module {
    viewModel { MainViewModel(get()) }
}
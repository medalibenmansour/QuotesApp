package com.daly.quotesapp.data.network.factories

import com.daly.quotesapp.data.network.api.ApiClient
import com.daly.quotesapp.data.network.api.ApiClientSecond
import retrofit2.Retrofit

class ApiClientFactory(private vararg val retrofit: Retrofit) : IApiFactory {

    override val client: ApiClient
        get() = retrofit[0].create(ApiClient::class.java)

    override val clientSecond: ApiClientSecond
        get() = retrofit[1].create(ApiClientSecond::class.java)
}

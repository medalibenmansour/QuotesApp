package com.daly.quotesapp.data.network.factories

import com.daly.quotesapp.data.network.api.ApiClient
import com.daly.quotesapp.data.network.api.ApiClientSecond

interface IApiFactory {
    val client: ApiClient
    val clientSecond: ApiClientSecond
}
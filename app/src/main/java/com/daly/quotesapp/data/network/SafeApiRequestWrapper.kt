package com.daly.quotesapp.data.network

import com.daly.quotesapp.utils.ApiException
import org.json.JSONObject
import retrofit2.Response

abstract class SafeApiRequestWrapper {

    suspend fun <T : Any> makeSafeRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()
        val b = response.body()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            val jsonObject = JSONObject(response.errorBody()?.string())
            val error = jsonObject.getString("error")
            val code = response.code()
            throw ApiException(message = "$error with code $code")
        }
    }
}
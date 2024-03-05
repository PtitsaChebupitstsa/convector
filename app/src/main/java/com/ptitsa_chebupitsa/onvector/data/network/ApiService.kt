package com.ptitsa_chebupitsa.onvector.data.network

import com.ptitsa_chebupitsa.onvector.data.network.model.CurrencyInfoJsonContainerDto
import com.ptitsa_chebupitsa.onvector.data.network.model.CurrencyNameContainerDto
import retrofit2.http.GET

interface ApiService {

        @GET("daily_json.js")
        suspend fun getCurrencyInfo():CurrencyNameContainerDto
        @GET("daily_json.js")
        suspend fun getCurrencyList():CurrencyNameContainerDto
}

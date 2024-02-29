package com.ptitsa_chebupitsa.onvector.data.network

import com.ptitsa_chebupitsa.onvector.data.network.model.CurrencyInfoJsonContainerDto
import com.ptitsa_chebupitsa.onvector.data.network.model.CurrencyNameContainerDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("daily_json.js")
    suspend fun getCurrencyInfo(
        //TODO не понятно нужнн ли запрос данных
    ): CurrencyNameContainerDto
    @GET("daily_json.js")
    suspend fun getCurrencyList(
        @Query(QUERY_PARAM_FROM_CURRENCY) currency:String
    ): CurrencyInfoJsonContainerDto
    companion object{
        private const val QUERY_PARAM_FROM_CURRENCY = "Valute"
        private const val CURRENCY="USD"
    }
}
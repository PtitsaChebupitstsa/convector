package com.ptitsa_chebupitsa.onvector

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.ptitsa_chebupitsa.onvector.data.ConvectorRepositoryImpl
import com.ptitsa_chebupitsa.onvector.data.network.ApiFactory
import com.ptitsa_chebupitsa.onvector.data.network.model.CurrencyInfoJsonContainerDto
import com.ptitsa_chebupitsa.onvector.data.network.model.CurrencyContainerDto
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        lifecycleScope.launch {
//
//            val currencyCODES = apiNameCurrencyTest()
//            Log.d("ApiTestName", currencyCODES.toString())
////
//            currencyCODES.map {
//                Log.d("ApiTestItem", apiCurrencyTest(it).name.toString())
//                apiCurrencyTest(it)
//            }
////            Log.d("tessst",testJson(currencyCODES.toString()).toString())
////           val a = testJson(currencyCODES.toString())
////        currencyCODES.map {
////            Log.d("tesssssssT",testJson(it).toString())
////            testJson(it)
//        }

    }

    private suspend fun apiNameCurrencyTest(): List<String> {

        val response = ApiFactory.apiService.getCurrencyInfo()
        val valueObject = response.currency
        return valueObject.keys.toList()
    }

    private suspend fun apiCurrencyTest(nameCurrency: String): CurrencyContainerDto {
        val response = ApiFactory.apiService.getCurrencyInfo()
        val valueObject = response.currency[nameCurrency]
        return CurrencyContainerDto(
            iD = valueObject?.iD.toString(),
            name = valueObject?.name.toString(),
            charCode = valueObject?.charCode.toString(),
            numCode = valueObject?.numCode.toString(),
            nominal = valueObject?.nominal,
            value = valueObject?.value.toString(),
            previous = valueObject?.previous.toString()
        )
    }

    private fun mapperJson(json: CurrencyInfoJsonContainerDto): List<CurrencyContainerDto> {
        val result = mutableListOf<CurrencyContainerDto>()
        val jsonObject = json.json ?: return result
        val jsonCurrencyKeySet = jsonObject.keySet()
        for (jsonCurrencyKey in jsonCurrencyKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(jsonCurrencyKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val currencyInfo = Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey),
                    CurrencyContainerDto::class.java
                )
                Log.d("mapperJson", currencyInfo.toString())
                result.add(currencyInfo)
            }
        }
        return result
    }
}



package com.ptitsa_chebupitsa.onvector.domain

import androidx.lifecycle.LiveData

interface ConvectorRepository {
    fun getCurrencyInfo(charCode: String): LiveData<CurrencyInfo>
    fun getCurrencyList(): LiveData<List<CurrencyInfo>>
    fun loadData()
    fun convectCurrency (value:Double):LiveData<List<ConvectCurrency>>
}
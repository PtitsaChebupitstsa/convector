package com.ptitsa_chebupitsa.onvector.domain

import androidx.lifecycle.LiveData

interface CurrencyRepository {
    fun getCurrencyInfo(charCode:String):LiveData<CurrencyInfo>
    fun getCurrencyInfoList():LiveData<List<CurrencyInfo>>
    fun loadData()
}
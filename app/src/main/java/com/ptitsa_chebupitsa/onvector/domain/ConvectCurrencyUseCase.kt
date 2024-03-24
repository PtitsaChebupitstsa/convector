package com.ptitsa_chebupitsa.onvector.domain

import androidx.lifecycle.LiveData
import javax.inject.Inject

class ConvectCurrencyUseCase @Inject constructor(private val repository: ConvectorRepository) {
    fun convectCurrency (value:Double): LiveData<List<ConvectCurrency>>{
       return repository.convectCurrency(value)
    }
}
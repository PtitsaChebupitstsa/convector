package com.ptitsa_chebupitsa.onvector.domain

import androidx.lifecycle.LiveData
import javax.inject.Inject

class ConvectCurrencyUseCase @Inject constructor(private val repository: ConvectorRepository) {
    operator  fun invoke(value:Double): LiveData<List<ConvectCurrency>> = repository.convectCurrency(value)
}
package com.ptitsa_chebupitsa.onvector.domain

import javax.inject.Inject

class GetCurrencyInfoUseCase @Inject constructor(private val repository: CurrencyRepository) {
    operator fun invoke(charCode: String) = repository.getCurrencyInfo(charCode)
}
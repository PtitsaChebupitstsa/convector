package com.ptitsa_chebupitsa.onvector.domain

import javax.inject.Inject

class GetCurrencyListUseCase @Inject constructor(private val repository: CurrencyRepository) {
    operator fun invoke() = repository.getCurrencyList()
}
package com.ptitsa_chebupitsa.onvector.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.ptitsa_chebupitsa.onvector.domain.ConvectCurrency
import com.ptitsa_chebupitsa.onvector.domain.ConvectCurrencyUseCase
import com.ptitsa_chebupitsa.onvector.domain.GetCurrencyInfoUseCase
import com.ptitsa_chebupitsa.onvector.domain.LoadDataUseCase
import javax.inject.Inject

class CurrencyConvectViewModel @Inject constructor(
    private val getCurrencyInfoUseCase: GetCurrencyInfoUseCase,
    private val convectCurrency: ConvectCurrencyUseCase,
    private val loadDataUseCase: LoadDataUseCase
): ViewModel() {
    private val _currencyInfoList = MutableLiveData<List<ConvectCurrency>>()
    val currencyList: LiveData<List<ConvectCurrency>>
        get() = _currencyInfoList

    init {
        convect(DEFAULT_VALUE)
        loadDataUseCase()
    }

    fun convect(value: Double) {
        convectCurrency(value).observeForever {
            _currencyInfoList.value = it
        }
    }
companion object{
    private const val DEFAULT_VALUE = 0.0
}

}



package com.ptitsa_chebupitsa.onvector.presentation

import androidx.lifecycle.ViewModel
import com.ptitsa_chebupitsa.onvector.domain.GetCurrencyInfoUseCase
import com.ptitsa_chebupitsa.onvector.domain.GetCurrencyListUseCase
import com.ptitsa_chebupitsa.onvector.domain.LoadDataUseCase
import javax.inject.Inject

class CurrencyListViewModel @Inject constructor(
    private val loadDataUseCase: LoadDataUseCase,
    private val getCurrencyListUseCase: GetCurrencyListUseCase,
):ViewModel(){

    val currencyInfoList = getCurrencyListUseCase()



    init {
        loadDataUseCase()
    }


}
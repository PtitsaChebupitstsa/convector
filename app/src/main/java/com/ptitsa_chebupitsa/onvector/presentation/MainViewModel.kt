package com.ptitsa_chebupitsa.onvector.presentation

import androidx.lifecycle.ViewModel
import com.ptitsa_chebupitsa.onvector.domain.GetCurrencyInfoUseCase
import com.ptitsa_chebupitsa.onvector.domain.GetCurrencyListUseCase
import com.ptitsa_chebupitsa.onvector.domain.LoadDataUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getCurrencyInfoUseCase: GetCurrencyInfoUseCase,
    private val getCurrencyListUseCase: GetCurrencyListUseCase,
    private val loadDataUseCase: LoadDataUseCase
) :ViewModel(){

    val currencyInfoList = getCurrencyListUseCase()

    fun getDetailInfo(charCode:String)= getCurrencyInfoUseCase(charCode)

   init {
       loadDataUseCase()
   }


}
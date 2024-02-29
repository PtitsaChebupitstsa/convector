package com.ptitsa_chebupitsa.onvector.data

import androidx.lifecycle.LiveData
import com.ptitsa_chebupitsa.onvector.domain.ConvectorRepository
import com.ptitsa_chebupitsa.onvector.domain.CurrencyInfo
import javax.inject.Inject

class ConvectorRepositoryImpl @Inject constructor():ConvectorRepository {
    override fun getCurrencyInfo(charCode: String): LiveData<CurrencyInfo> {
        TODO("Not yet implemented")
    }

    override fun getCurrencyList(): LiveData<List<CurrencyInfo>> {
        TODO("Not yet implemented")
    }

    override fun loadData() {
        TODO("Not yet implemented")
    }
}
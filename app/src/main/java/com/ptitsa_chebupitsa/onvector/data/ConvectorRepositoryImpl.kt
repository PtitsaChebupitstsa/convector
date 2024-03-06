package com.ptitsa_chebupitsa.onvector.data

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.ptitsa_chebupitsa.onvector.data.db.ConvectorDao
import com.ptitsa_chebupitsa.onvector.data.db.CurrencyItemDbModel
import com.ptitsa_chebupitsa.onvector.data.mapper.ConvectorMapper
import com.ptitsa_chebupitsa.onvector.data.network.ApiFactory
import com.ptitsa_chebupitsa.onvector.data.network.ApiService
import com.ptitsa_chebupitsa.onvector.domain.ConvectorRepository
import com.ptitsa_chebupitsa.onvector.domain.CurrencyInfo
import kotlinx.coroutines.delay
import javax.inject.Inject

class ConvectorRepositoryImpl @Inject constructor(
    private val mapper: ConvectorMapper,
    private val application: Application,
    private val convectorDao: ConvectorDao
) : ConvectorRepository {

    override fun getCurrencyInfo(charCode: String): LiveData<CurrencyInfo> {
        val currencyInfo = convectorDao.getCurrencyInfoAboutItem(charCode)
        return currencyInfo.map { mapper.mapDbCurrencyModelToEntity(it) }
    }

    override fun getCurrencyList(): LiveData<List<CurrencyInfo>> {
        val currencyInfoList = convectorDao.getCurrencyList()
        return currencyInfoList.map {
            mapper.mapDbModelCurrencyListToEntityList(it)
        }
    }

    override suspend fun loadData() {
        while (true) {
            try {
                val currencyContainer = ApiFactory.apiService.getCurrencyList()
                val coinInfoList =
                    mapper.mapCurrencyContainerToListCurrencyInfoList(currencyContainer)
                Log.d("loadData", coinInfoList.toString())
                convectorDao.insertCurrencyList(coinInfoList)
            } catch (e: Exception) {
                Log.d("loadData", e.toString())
            }
            delay(1000)
        }
    }
}





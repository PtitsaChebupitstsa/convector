package com.ptitsa_chebupitsa.onvector.data

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.ptitsa_chebupitsa.onvector.data.db.ConvectorDao
import com.ptitsa_chebupitsa.onvector.data.db.CurrencyItemDbModel
import com.ptitsa_chebupitsa.onvector.data.mapper.ConvectorMapper
import com.ptitsa_chebupitsa.onvector.data.network.ApiFactory
import com.ptitsa_chebupitsa.onvector.data.network.ApiFactory.apiService
import com.ptitsa_chebupitsa.onvector.data.network.ApiService
import com.ptitsa_chebupitsa.onvector.data.workers.RefreshDataWorker
import com.ptitsa_chebupitsa.onvector.domain.ConvectCurrency
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

    override fun loadData() {
        val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
            RefreshDataWorker.NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshDataWorker.makeRequest()
        )
    }

    override fun convectCurrency(value: Double): LiveData<List<ConvectCurrency>> {
        val currencyList = getCurrencyList()
        return currencyList.map {
            mapper.mapCurrencyListToConvectCurrencyList(it, value)
        }
    }
}








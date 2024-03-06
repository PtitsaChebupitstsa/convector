package com.ptitsa_chebupitsa.onvector.data.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.ListenableWorker
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters
import com.ptitsa_chebupitsa.onvector.data.db.ConvectorDao
import com.ptitsa_chebupitsa.onvector.data.mapper.ConvectorMapper
import com.ptitsa_chebupitsa.onvector.data.network.ApiService
import kotlinx.coroutines.delay
import javax.inject.Inject

class RefreshDataWorker(
    context: Context,
    workerParameters: WorkerParameters,
    private val convectorDao: ConvectorDao,
    private val apiService: ApiService,
    private val mapper: ConvectorMapper
) : CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        while (true) {
            try {
                val currencyContainer = apiService.getCurrencyList()
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

    class Factory @Inject constructor(
        private val convectorDao: ConvectorDao,
        private val apiService: ApiService,
        private val mapper: ConvectorMapper
    ) : ChildWorkFactory {
        override fun create(
            context: Context,
            workerParameters: WorkerParameters
        ): ListenableWorker {
            return RefreshDataWorker(
                context, workerParameters, convectorDao, apiService, mapper
            )
        }

    }

    companion object {
        const val NAME = "ConvectorWorker"
        fun makeRequest(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<RefreshDataWorker>().build()
        }
    }

}
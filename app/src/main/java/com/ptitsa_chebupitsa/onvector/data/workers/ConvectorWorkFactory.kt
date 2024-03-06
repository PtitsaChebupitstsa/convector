package com.ptitsa_chebupitsa.onvector.data.workers

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import javax.inject.Inject
import javax.inject.Provider

class ConvectorWorkFactory @Inject constructor(
    private val workerProviders: @JvmSuppressWildcards Map<Class<out ListenableWorker>, Provider<ChildWorkFactory>>
) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return when (workerClassName) {
            RefreshDataWorker::class.qualifiedName -> {
                val childWorkFactory = workerProviders[RefreshDataWorker::class.java]?.get()
                return childWorkFactory?.create(appContext, workerParameters)
            }

            else -> null
        }
    }

}
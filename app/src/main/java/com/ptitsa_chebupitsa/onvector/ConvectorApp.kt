package com.ptitsa_chebupitsa.onvector

import android.app.Application
import androidx.work.Configuration
import com.ptitsa_chebupitsa.onvector.data.db.AppDataBase

import com.ptitsa_chebupitsa.onvector.data.di.DaggerApplicationComponent
import com.ptitsa_chebupitsa.onvector.data.mapper.ConvectorMapper
import com.ptitsa_chebupitsa.onvector.data.network.ApiFactory
import com.ptitsa_chebupitsa.onvector.data.workers.ConvectorWorkFactory
import com.ptitsa_chebupitsa.onvector.data.workers.RefreshDataWorker
import javax.inject.Inject

class ConvectorApp:Application(), Configuration.Provider {
    @Inject
    lateinit var workerFactory: ConvectorWorkFactory
    val component by lazy {
       DaggerApplicationComponent.factory().create(this)
    }
    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }
}
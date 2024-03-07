package com.ptitsa_chebupitsa.onvector.data.di

import com.ptitsa_chebupitsa.onvector.data.di.qualifiers.WorkerKey
import com.ptitsa_chebupitsa.onvector.data.workers.ChildWorkFactory
import com.ptitsa_chebupitsa.onvector.data.workers.RefreshDataWorker
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface WorkerModule {
    @Binds
    @IntoMap
    @WorkerKey(RefreshDataWorker::class)
    fun bindsRefreshDataWorkerFactory(worker: RefreshDataWorker.Factory): ChildWorkFactory
}
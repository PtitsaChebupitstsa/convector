package com.ptitsa_chebupitsa.onvector.data.di.qualifiers

import dagger.MapKey
import androidx.work.ListenableWorker
import kotlin.reflect.KClass

@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class WorkerKey(val value:KClass< out ListenableWorker>)

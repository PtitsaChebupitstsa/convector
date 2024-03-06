package com.ptitsa_chebupitsa.onvector.data.workers

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters

interface ChildWorkFactory {
    fun create(
        context: Context,
        workerParameters: WorkerParameters
    ):ListenableWorker
}
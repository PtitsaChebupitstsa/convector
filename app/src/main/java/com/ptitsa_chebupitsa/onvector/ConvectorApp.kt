package com.ptitsa_chebupitsa.onvector

import android.app.Application
import com.ptitsa_chebupitsa.onvector.data.di.DaggerApplicationComponent

class ConvectorApp:Application() {
    val component by lazy {
       DaggerApplicationComponent.factory().create(this)
    }
}
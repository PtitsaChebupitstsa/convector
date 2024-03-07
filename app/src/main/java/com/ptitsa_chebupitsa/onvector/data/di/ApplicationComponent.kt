package com.ptitsa_chebupitsa.onvector.data.di

import android.app.Application
import com.ptitsa_chebupitsa.onvector.ConvectorApp
import com.ptitsa_chebupitsa.onvector.presentation.MainActivity
import com.ptitsa_chebupitsa.onvector.data.di.annotation.ApplicationScope
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class,ViewModelModule::class,WorkerModule::class])
interface ApplicationComponent {
    fun inject(activity: MainActivity)
    fun inject(application: ConvectorApp)

    @Component.Factory
    interface Factory{
        fun create(
            @BindsInstance application: Application
        ):ApplicationComponent
    }
}
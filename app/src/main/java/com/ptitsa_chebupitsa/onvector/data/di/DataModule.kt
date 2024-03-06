package com.ptitsa_chebupitsa.onvector.data.di

import android.app.Application
import com.ptitsa_chebupitsa.onvector.data.ConvectorRepositoryImpl
import com.ptitsa_chebupitsa.onvector.data.db.AppDataBase
import com.ptitsa_chebupitsa.onvector.data.db.ConvectorDao
import com.ptitsa_chebupitsa.onvector.data.di.annotation.ApplicationScope
import com.ptitsa_chebupitsa.onvector.data.network.ApiFactory
import com.ptitsa_chebupitsa.onvector.data.network.ApiService
import com.ptitsa_chebupitsa.onvector.domain.ConvectorRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {
    @Binds
    @ApplicationScope
    fun bindConvectorRepository(impl: ConvectorRepositoryImpl):ConvectorRepository

    companion object{
        @Provides
        @ApplicationScope
        fun provideConvectorDao(application: Application):ConvectorDao{
            return AppDataBase.getInsert(application).currencyListDao()
        }
        @Provides
        @ApplicationScope
        fun provideApiService():ApiService{
            return ApiFactory.apiService
        }
    }
}
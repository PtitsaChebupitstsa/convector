package com.ptitsa_chebupitsa.onvector.data.di

import androidx.lifecycle.ViewModel
import com.ptitsa_chebupitsa.onvector.data.di.qualifiers.ViewModelKey
import com.ptitsa_chebupitsa.onvector.presentation.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
@IntoMap
@Binds
@ViewModelKey(MainViewModel::class)
fun bindMainViewModel(viewModel: MainViewModel):ViewModel
}
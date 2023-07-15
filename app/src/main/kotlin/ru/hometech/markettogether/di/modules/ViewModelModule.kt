package ru.hometech.markettogether.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.hometech.core_common.di.AppScope
import ru.hometech.core_common.di.MultiViewModelFactory
import ru.hometech.core_common.di.ViewModelKey
import ru.hometech.markettogether.ui.MainViewModel

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @AppScope
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}
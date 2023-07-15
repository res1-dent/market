package ru.hometech.feature_rus_quality.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.hometech.core_common.di.PerFeature
import ru.hometech.core_common.di.ViewModelKey
import ru.hometech.feature_rus_quality.ui.ProductInfoViewModel

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ProductInfoViewModel::class)
    @PerFeature
    fun bindProductInfoViewModel(viewModel: ProductInfoViewModel): ViewModel
}
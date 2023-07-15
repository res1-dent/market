package ru.hometech.feature_shopping.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.hometech.core_common.di.PerFeature
import ru.hometech.core_common.di.ViewModelKey
import ru.hometech.feature_shopping.ui.ShoppingViewModel

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ShoppingViewModel::class)
    @PerFeature
    fun bindShoppingViewModel(viewModel: ShoppingViewModel): ViewModel
}
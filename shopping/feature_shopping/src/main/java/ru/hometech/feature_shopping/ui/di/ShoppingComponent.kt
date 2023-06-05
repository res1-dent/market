package ru.hometech.feature_shopping.ui.di

import dagger.Component
import ru.hometech.core_common.di.BaseComponent
import ru.hometech.core_common.di.injector.ParameterlessInjector
import ru.hometech.feature_shopping.ui.ShoppingViewModel

@Component
interface ShoppingComponent: BaseComponent {

    override fun getViewModel(): ShoppingViewModel

    companion object ShoppingComponentInjector: ParameterlessInjector<ShoppingComponent>() {

        override fun create(): ShoppingComponent = DaggerShoppingComponent.create()
    }
}

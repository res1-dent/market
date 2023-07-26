package com.hometech.core_shopping.impl.di

import com.hometech.core_shopping.api.di.CoreShoppingDependencies
import com.hometech.core_shopping.impl.di.modules.DataModule
import com.hometech.core_shopping.impl.di.modules.DomainModule
import dagger.Component
import ru.hometech.core_common.di.AppDependencies
import ru.hometech.core_common.di.PerFeature
import ru.hometech.core_common.di.injector.ParameterlessInjector
import ru.hometech.core_common.di.injector.findComponent
import ru.hometech.core_network.di.CoreNetworkDependenciesProvider
import ru.hometech.core_network_api.di.CoreNetworkDependencies


@PerFeature
@Component(
    dependencies = [
        AppDependencies::class,
        CoreNetworkDependencies::class
    ],
    modules = [
        DomainModule::class,
        DataModule::class
    ]
)
internal interface CoreShoppingComponent : CoreShoppingDependencies {

    companion object CoreShoppingComponentInjector :
        ParameterlessInjector<CoreShoppingComponent>(CoreShoppingComponent::class) {
        override fun create(): CoreShoppingComponent {
            return DaggerCoreShoppingComponent.builder()
                .getAppDependencies(findComponent())
                .getCoreNetworkDependencies(CoreNetworkDependenciesProvider.provide())
                .build()
        }
    }

    @Component.Builder
    interface Builder {
        fun getAppDependencies(dependencies: AppDependencies): Builder
        fun getCoreNetworkDependencies(dependencies: CoreNetworkDependencies): Builder
        fun build(): CoreShoppingComponent
    }
}


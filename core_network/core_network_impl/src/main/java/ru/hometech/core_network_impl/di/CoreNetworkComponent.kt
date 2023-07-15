package ru.hometech.core_network_impl.di

import dagger.Component
import dagger.Component.Builder
import ru.hometech.core_common.di.AppDependencies
import ru.hometech.core_common.di.PerFeature
import ru.hometech.core_common.di.injector.ParameterlessInjector
import ru.hometech.core_common.di.injector.findComponent
import ru.hometech.core_network_api.di.CoreNetworkDependencies
import ru.hometech.core_network_impl.di.modules.DataModule
import ru.hometech.core_network_impl.di.modules.NetworkModule

@Component(
    dependencies = [AppDependencies::class],
    modules = [
        NetworkModule::class,
        DataModule::class
    ]
)
@PerFeature
interface CoreNetworkComponent : CoreNetworkDependencies {

    companion object NetworkComponentInjector :
        ParameterlessInjector<CoreNetworkComponent>(CoreNetworkComponent::class) {
        override fun create(): CoreNetworkComponent =
            DaggerCoreNetworkComponent.builder().appDependencies(findComponent()).build()
    }

    @Component.Builder
    interface Builder {
        fun appDependencies(deps: AppDependencies): Builder
        fun build(): CoreNetworkComponent
    }
}
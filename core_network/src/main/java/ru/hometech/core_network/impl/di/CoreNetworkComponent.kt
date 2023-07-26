package ru.hometech.core_network.impl.di

import dagger.Component
import ru.hometech.core_common.di.AppDependencies
import ru.hometech.core_common.di.PerFeature
import ru.hometech.core_common.di.injector.ParameterlessInjector
import ru.hometech.core_common.di.injector.findComponent
import ru.hometech.core_network.api.di.CoreNetworkDependencies
import ru.hometech.core_network.impl.di.modules.DataModule
import ru.hometech.core_network.impl.di.modules.NetworkModule

@Component(
    dependencies = [AppDependencies::class],
    modules = [
        NetworkModule::class,
        DataModule::class
    ]
)
@PerFeature
internal interface CoreNetworkComponent : CoreNetworkDependencies {

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
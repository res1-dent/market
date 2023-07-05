package ru.hometech.core_network_impl.di

import dagger.Component
import ru.hometech.core_common.di.PerFeature
import ru.hometech.core_common.di.injector.ParameterlessInjector
import ru.hometech.core_network_api.di.CoreNetworkDependencies
import ru.hometech.core_network_impl.di.modules.DataModule

@Component(
    modules = [DataModule::class]
)
@PerFeature
interface CoreNetworkComponent : CoreNetworkDependencies {

    companion object NetworkComponentInjector :
        ParameterlessInjector<CoreNetworkComponent>(CoreNetworkComponent::class) {
        override fun create(): CoreNetworkComponent {
            return DaggerCoreNetworkComponent.create()
        }
    }
}
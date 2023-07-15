package ru.hometech.core_rus_quality_impl.di

import dagger.Component
import ru.hometech.core_common.di.PerFeature
import ru.hometech.core_common.di.injector.ParameterlessInjector
import ru.hometech.core_network.di.CoreNetworkDependenciesProvider
import ru.hometech.core_network_api.di.CoreNetworkDependencies
import ru.hometech.core_rus_quality_api.di.CoreRusQualityDependencies

@PerFeature
@Component(
    dependencies = [CoreNetworkDependencies::class],
    modules = [UseCasesModule::class]
)
interface CoreRusQualityComponent : CoreRusQualityDependencies {

    companion object :
        ParameterlessInjector<CoreRusQualityComponent>(CoreRusQualityComponent::class) {
        override fun create(): CoreRusQualityComponent {
            return DaggerCoreRusQualityComponent.builder()
                .coreNetworkDependencies(CoreNetworkDependenciesProvider.provide()).build()
        }
    }

    @Component.Builder
    interface Builder {
        fun coreNetworkDependencies(dependencies: CoreNetworkDependencies): Builder
        fun build(): CoreRusQualityComponent
    }
}
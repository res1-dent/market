package ru.hometech.feature_rus_quality.di

import dagger.Component
import ru.hometech.core_common.di.AppDependencies
import ru.hometech.core_common.di.FeatureComponent
import ru.hometech.core_common.di.MultiViewModelFactory
import ru.hometech.core_common.di.PerFeature
import ru.hometech.core_common.di.injector.ParameterlessInjector
import ru.hometech.core_common.di.injector.findComponent
import ru.hometech.core_rus_quality.CoreRusQualityDependenciesProvider
import ru.hometech.core_rus_quality_api.di.CoreRusQualityDependencies
import ru.hometech.feature_rus_quality.di.modules.ViewModelModule

@PerFeature
@Component(modules = [ViewModelModule::class], dependencies = [CoreRusQualityDependencies::class])
interface RusQualityComponent : FeatureComponent {

    companion object RusQualityComponentInjector :
        ParameterlessInjector<RusQualityComponent>(RusQualityComponent::class) {

        override fun create(): RusQualityComponent {
            return DaggerRusQualityComponent.builder()
                .coreRusQualityDependencies(CoreRusQualityDependenciesProvider.provide()).build()
        }
    }

    @Component.Builder
    interface Builder {
        fun coreRusQualityDependencies(dependencies: CoreRusQualityDependencies): Builder
        fun build(): RusQualityComponent
    }
}
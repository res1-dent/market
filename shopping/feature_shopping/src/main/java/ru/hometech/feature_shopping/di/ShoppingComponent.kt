package ru.hometech.feature_shopping.di

import com.hometech.core_auth.CoreAuthDependenciesProvider
import com.hometech.core_auth_api.di.CoreAuthDependencies
import com.hometech.core_shopping.CoreShoppingDependenciesProvider
import com.hometech.core_shopping.api.di.CoreShoppingDependencies
import dagger.Component
import ru.hometech.core_common.di.AppDependencies
import ru.hometech.core_common.di.FeatureComponent
import ru.hometech.core_common.di.PerFeature
import ru.hometech.core_common.di.injector.ParameterlessInjector
import ru.hometech.core_common.di.injector.findComponent
import ru.hometech.core_network.di.CoreNetworkDependenciesProvider
import ru.hometech.core_network.api.di.CoreNetworkDependencies
import ru.hometech.feature_shopping.di.modules.ViewModelModule


@Component(
    modules = [
        UiModule::class,
        ViewModelModule::class
    ],
    dependencies = [
        AppDependencies::class,
        CoreShoppingDependencies::class,
        CoreAuthDependencies::class,
        CoreNetworkDependencies::class
    ]
)
@PerFeature
interface ShoppingComponent : FeatureComponent {

    companion object ShoppingComponentInjector :
        ParameterlessInjector<ShoppingComponent>(ShoppingComponent::class) {

        override fun create(): ShoppingComponent =
            DaggerShoppingComponent.builder()
                .appDependencies(findComponent())
                .coreShoppingDependencies(CoreShoppingDependenciesProvider.provide())
                .coreAuthDependencies(CoreAuthDependenciesProvider.provide())
                .coreNetworkDependencies(CoreNetworkDependenciesProvider.provide())
                .build()
    }

    @Component.Builder
    interface Builder {
        fun appDependencies(dependencies: AppDependencies): Builder
        fun coreShoppingDependencies(dependencies: CoreShoppingDependencies): Builder
        fun coreAuthDependencies(dependencies: CoreAuthDependencies): Builder
        fun coreNetworkDependencies(dependencies: CoreNetworkDependencies): Builder
        fun build(): ShoppingComponent
    }
}

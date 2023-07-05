package ru.hometech.feature_shopping.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.core_shopping_api.di.CoreShoppingDependencies
import com.hometech.core_auth.CoreAuthDependenciesProvider
import com.hometech.core_auth_api.di.CoreAuthDependencies
import com.hometech.core_shopping.CoreShoppingDependenciesProvider
import dagger.Binds
import dagger.Component
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import ru.hometech.core_common.di.FeatureComponent
import ru.hometech.core_common.di.MultiViewModelFactory
import ru.hometech.core_common.di.PerFeature
import ru.hometech.core_common.di.ViewModelKey
import ru.hometech.core_common.di.injector.ParameterlessInjector
import ru.hometech.feature_shopping.ui.ShoppingViewModel
import ru.hometech.feature_shopping.ui.TestViewModel
import kotlin.reflect.KClass

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ShoppingViewModel::class)
    @PerFeature
    fun bindShoppingViewModel(viewModel: ShoppingViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TestViewModel::class)
    @PerFeature
    fun bindTestViewModel(viewModel: TestViewModel): ViewModel
}


@Component(
    modules = [
        UiModule::class,
        ViewModelModule::class
    ],
    dependencies = [
        CoreShoppingDependencies::class,
        CoreAuthDependencies::class
    ]
)
@PerFeature
interface ShoppingComponent : FeatureComponent {


    companion object ShoppingComponentInjector :
        ParameterlessInjector<ShoppingComponent>(ShoppingComponent::class) {

        override fun create(): ShoppingComponent =
            DaggerShoppingComponent.builder()
                .coreShoppingDependencies(CoreShoppingDependenciesProvider.provide())
                .coreAuthDependencies(CoreAuthDependenciesProvider.provide())
                .build()
    }

    @Component.Builder
    interface Builder {
        fun coreShoppingDependencies(dependencies: CoreShoppingDependencies): Builder
        fun coreAuthDependencies(dependencies: CoreAuthDependencies): Builder
        fun build(): ShoppingComponent
    }
}

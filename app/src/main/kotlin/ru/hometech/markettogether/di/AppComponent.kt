package ru.hometech.markettogether.di

import android.content.Context
import androidx.lifecycle.ViewModel
import com.hometech.core_auth.CoreAuthDependenciesProvider
import com.hometech.core_auth_api.di.CoreAuthDependencies
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap
import ru.hometech.core_common.di.AppDependencies
import ru.hometech.core_common.di.AppScope
import ru.hometech.core_common.di.FeatureComponent
import ru.hometech.core_common.di.ViewModelKey
import ru.hometech.core_common.di.injector.Injector
import ru.hometech.feature_shopping.ui.ShoppingViewModel
import ru.hometech.feature_shopping.ui.TestViewModel
import ru.hometech.markettogether.App
import ru.hometech.markettogether.MainViewModel

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}


@Component(
    modules = [
        AppModule::class,
        ViewModelModule::class
    ],
    dependencies = [
        CoreAuthDependencies::class
    ]
)
@AppScope
interface AppComponent : FeatureComponent, AppDependencies {

    fun inject(app: App)

    companion object MainComponentInjector :
        Injector<Context, AppComponent>(AppComponent::class) {

        override fun create(params: Context): AppComponent =
            DaggerAppComponent
                .builder()
                .context(params)
                .getCoreAuthDependencies(CoreAuthDependenciesProvider.provide())
                .build()
    }

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun getCoreAuthDependencies(deps: CoreAuthDependencies): Builder
        fun build(): AppComponent
    }
}

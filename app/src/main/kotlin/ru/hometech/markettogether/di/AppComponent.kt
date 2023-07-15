package ru.hometech.markettogether.di

import android.content.Context
import com.hometech.core_auth.CoreAuthDependenciesProvider
import com.hometech.core_auth_api.di.CoreAuthDependencies
import dagger.BindsInstance
import dagger.Component
import ru.hometech.core_common.di.AppDependencies
import ru.hometech.core_common.di.AppScope
import ru.hometech.core_common.di.FeatureComponent
import ru.hometech.core_common.di.injector.Injector
import ru.hometech.core_network_api.di.CoreNetworkDependencies
import ru.hometech.markettogether.App
import ru.hometech.markettogether.di.modules.AppModule
import ru.hometech.markettogether.di.modules.ViewModelModule


@Component(
    modules = [
        AppModule::class,
        ViewModelModule::class
    ],
    dependencies = [
        CoreAuthDependencies::class,
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

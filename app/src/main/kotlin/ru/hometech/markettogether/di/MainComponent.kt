package ru.hometech.markettogether.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.hometech.core_common.di.AppDependencies
import ru.hometech.core_common.di.AppScope
import ru.hometech.core_common.di.BaseComponent
import ru.hometech.core_common.di.injector.Injector
import ru.hometech.markettogether.MainViewModel

@Component
@AppScope
interface MainComponent : BaseComponent, AppDependencies {
    override fun getViewModel(): MainViewModel

    companion object MainComponentInjector : Injector<Context, MainComponent>() {

        override fun create(params: Context): MainComponent =
            DaggerMainComponent.builder().context(params).build()
    }

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): MainComponent
    }
}

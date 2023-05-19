package ru.hometech.markettogether.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.hometech.core_common.AppDependencies
import ru.hometech.core_common.di.Injector
import ru.hometech.markettogether.MainActivity

@Component(
    dependencies = [],
    modules = [
        Module1::class
    ]
)
interface MainComponent : AppDependencies {

    fun inject(act: MainActivity)

    companion object MainComponentInjector: Injector<Context, MainComponent>() {

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

@Module
class Module1 {

    @Provides
    fun provides(): Test = Test()
}

class Test {
    fun getInt() = 123
}
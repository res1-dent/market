package ru.hometech.markettogether.di

import dagger.Module
import dagger.Provides
import ru.hometech.core_common.coroutines.DispatchersProvider
import ru.hometech.core_common.di.AppScope
import ru.hometech.markettogether.DispatchersProviderImpl

@Module
class AppModule {

    @AppScope
    @Provides
    fun provideDispatchersProvider(): DispatchersProvider = DispatchersProviderImpl()
}
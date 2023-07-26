package com.hometech.core_shopping.impl.di.modules

import com.hometech.core_shopping.api.repositories.SharedProductsListRepository
import com.hometech.core_shopping.impl.repositories.SharedProductsListRepositoryImpl
import dagger.Binds
import dagger.Module
import ru.hometech.core_common.di.PerFeature

@Module
internal interface DataModule {

    @PerFeature
    @Binds
    fun bindSharedProductsListRepository(impl: SharedProductsListRepositoryImpl): SharedProductsListRepository
}
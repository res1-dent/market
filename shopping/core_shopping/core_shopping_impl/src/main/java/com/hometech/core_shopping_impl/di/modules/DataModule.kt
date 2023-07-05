package com.hometech.core_shopping_impl.di.modules

import com.example.core_shopping_api.repositories.SharedProductsListRepository
import com.hometech.core_shopping_impl.repositories.SharedProductsListRepositoryImpl
import dagger.Binds
import dagger.Module
import ru.hometech.core_common.di.PerFeature

@Module
interface DataModule {

    @PerFeature
    @Binds
    fun bindSharedProductsListRepository(impl: SharedProductsListRepositoryImpl): SharedProductsListRepository
}
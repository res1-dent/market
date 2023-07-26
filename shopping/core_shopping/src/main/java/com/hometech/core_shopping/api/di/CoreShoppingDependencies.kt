package com.hometech.core_shopping.api.di

import com.hometech.core_shopping.api.repositories.SharedProductsListRepository

interface CoreShoppingDependencies : ShoppingUseCasesDependencies {

    fun provideSharedProductsListRepository(): SharedProductsListRepository
}


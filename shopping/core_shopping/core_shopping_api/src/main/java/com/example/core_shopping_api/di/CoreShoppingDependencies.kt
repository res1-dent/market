package com.example.core_shopping_api.di

import com.example.core_shopping_api.repositories.SharedProductsListRepository

interface CoreShoppingDependencies : ShoppingUseCasesDependencies {

    fun provideSharedProductsListRepository(): SharedProductsListRepository
}


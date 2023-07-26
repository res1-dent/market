package com.hometech.core_shopping.api.di

import com.hometech.core_shopping.api.usecases.ShoppingUseCases

interface ShoppingUseCasesDependencies {
    fun provideAddProduct(): ShoppingUseCases.AddProduct
    fun provideDeleteProductById(): ShoppingUseCases.DeleteProductById
    fun provideUpdateProduct(): ShoppingUseCases.UpdateProduct
    fun provideGetAllProductsFlow(): ShoppingUseCases.GetAllProductsFlow
}
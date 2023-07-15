package com.example.core_shopping_api.di

import com.example.core_shopping_api.usecases.ShoppingUseCases

interface ShoppingUseCasesDependencies {
    fun provideAddProduct(): ShoppingUseCases.AddProduct
    fun provideDeleteProductById(): ShoppingUseCases.DeleteProductById
    fun provideUpdateProduct(): ShoppingUseCases.UpdateProduct
    fun provideGetAllProductsFlow(): ShoppingUseCases.GetAllProductsFlow
}
package com.hometech.core_shopping

import com.example.core_shopping_api.di.CoreShoppingDependencies
import com.hometech.core_shopping_impl.di.CoreShoppingComponent

object CoreShoppingDependenciesProvider {
    fun provide(): CoreShoppingDependencies = CoreShoppingComponent.getOrCreate()
}
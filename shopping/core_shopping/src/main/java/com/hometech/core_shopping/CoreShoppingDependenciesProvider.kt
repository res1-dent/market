package com.hometech.core_shopping

import com.hometech.core_shopping.api.di.CoreShoppingDependencies
import com.hometech.core_shopping.impl.di.CoreShoppingComponent

object CoreShoppingDependenciesProvider {
    fun provide(): CoreShoppingDependencies = CoreShoppingComponent.getOrCreate()
}
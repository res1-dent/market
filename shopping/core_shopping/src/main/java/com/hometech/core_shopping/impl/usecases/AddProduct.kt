package com.hometech.core_shopping.impl.usecases

import com.hometech.core_shopping.api.models.ProductDo
import com.hometech.core_shopping.api.repositories.SharedProductsListRepository
import com.hometech.core_shopping.api.usecases.ShoppingUseCases
import ru.hometech.core_common.di.PerFeature
import javax.inject.Inject

@PerFeature
internal class AddProduct @Inject constructor(
    private val sharedProductsListRepository: SharedProductsListRepository
) : ShoppingUseCases.AddProduct {

    override suspend operator fun invoke(params: ProductDo) {
        sharedProductsListRepository.addProduct(params)
    }
}
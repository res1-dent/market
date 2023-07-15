package com.hometech.core_shopping_impl.usecases

import com.example.core_shopping_api.models.ProductDo
import com.example.core_shopping_api.repositories.SharedProductsListRepository
import com.example.core_shopping_api.usecases.ShoppingUseCases
import ru.hometech.core_common.di.PerFeature
import javax.inject.Inject

@PerFeature
class AddProduct @Inject constructor(
    private val sharedProductsListRepository: SharedProductsListRepository
) : ShoppingUseCases.AddProduct {

    override suspend operator fun invoke(params: ProductDo) {
        sharedProductsListRepository.addProduct(params)
    }
}
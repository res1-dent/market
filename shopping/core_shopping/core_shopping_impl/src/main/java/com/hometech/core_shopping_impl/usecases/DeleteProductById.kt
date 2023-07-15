package com.hometech.core_shopping_impl.usecases

import com.example.core_shopping_api.repositories.SharedProductsListRepository
import com.example.core_shopping_api.usecases.ShoppingUseCases
import ru.hometech.core_common.di.PerFeature
import javax.inject.Inject

@PerFeature
class DeleteProductById @Inject constructor(
    private val sharedProductsListRepository: SharedProductsListRepository
): ShoppingUseCases.DeleteProductById {

    override suspend operator fun invoke(params: String) {
        sharedProductsListRepository.deleteProduct(params)
    }
}
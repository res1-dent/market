package com.hometech.core_shopping.impl.usecases

import com.hometech.core_shopping.api.repositories.SharedProductsListRepository
import com.hometech.core_shopping.api.usecases.ShoppingUseCases
import ru.hometech.core_common.di.PerFeature
import javax.inject.Inject

@PerFeature
internal class DeleteProductById @Inject constructor(
    private val sharedProductsListRepository: SharedProductsListRepository
): ShoppingUseCases.DeleteProductById {

    override suspend operator fun invoke(params: String) {
        sharedProductsListRepository.deleteProduct(params)
    }
}
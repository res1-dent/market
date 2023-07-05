package ru.hometech.feature_shopping.usecases

import com.example.core_shopping_api.repositories.SharedProductsListRepository
import ru.hometech.core_common.di.PerFeature
import javax.inject.Inject

@PerFeature
class DeleteProduct @Inject constructor(
    private val sharedProductsListRepository: SharedProductsListRepository
) {
    suspend operator fun invoke(productId: String) {
        sharedProductsListRepository.deleteProduct(productId)
    }
}
package ru.hometech.feature_shopping.usecases

import com.example.core_shopping_api.models.ProductDo
import com.example.core_shopping_api.repositories.SharedProductsListRepository
import ru.hometech.core_common.di.PerFeature
import ru.hometech.feature_shopping.models.mapping.ProductUiMapping
import javax.inject.Inject

@PerFeature
class AddProduct @Inject constructor(
    private val sharedProductsListRepository: SharedProductsListRepository
) {
    suspend operator fun invoke(productDo: ProductDo) {
        sharedProductsListRepository.addProduct(productDo)
    }
}
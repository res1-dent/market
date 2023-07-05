package ru.hometech.feature_shopping.usecases

import com.example.core_shopping_api.models.ProductDo
import ru.hometech.feature_shopping.models.ProductUi
import com.example.core_shopping_api.repositories.SharedProductsListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.hometech.core_common.di.PerFeature
import ru.hometech.feature_shopping.models.mapping.ProductUiMapping
import javax.inject.Inject


@PerFeature
class GetAllProductsFlow @Inject constructor(
    private val sharedProductsListRepository: SharedProductsListRepository,
) {
    operator fun invoke(): Flow<List<ProductDo>> {
        return sharedProductsListRepository.getAllProductsFlow()
            .map { it.sortedBy { it.name } }
    }
}
package com.hometech.core_shopping_impl.usecases

import com.example.core_shopping_api.models.ProductDo
import com.example.core_shopping_api.repositories.SharedProductsListRepository
import com.example.core_shopping_api.usecases.ShoppingUseCases
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.hometech.core_common.di.PerFeature
import javax.inject.Inject


@PerFeature
class GetAllProductsFlow @Inject constructor(
    private val sharedProductsListRepository: SharedProductsListRepository,
) : ShoppingUseCases.GetAllProductsFlow {

    override operator fun invoke(): Flow<List<ProductDo>> {
        return sharedProductsListRepository.getAllProductsFlow()
            .map { it.sortedBy { it.name } }
    }
}
package com.hometech.core_shopping.impl.usecases

import com.hometech.core_shopping.api.models.ProductDo
import com.hometech.core_shopping.api.repositories.SharedProductsListRepository
import com.hometech.core_shopping.api.usecases.ShoppingUseCases
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.hometech.core_common.di.PerFeature
import javax.inject.Inject


@PerFeature
internal class GetAllProductsFlow @Inject constructor(
    private val sharedProductsListRepository: SharedProductsListRepository,
) : ShoppingUseCases.GetAllProductsFlow {

    override operator fun invoke(): Flow<List<ProductDo>> {
        return sharedProductsListRepository.getAllProductsFlow()
            .map { it.sortedBy { it.name } }
    }
}
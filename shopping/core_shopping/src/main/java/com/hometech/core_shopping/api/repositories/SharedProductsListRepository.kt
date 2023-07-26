package com.hometech.core_shopping.api.repositories

import com.hometech.core_shopping.api.models.ProductDo
import kotlinx.coroutines.flow.Flow

/**
 * Репозиторий для работы с общим списком продуктов
 */
interface SharedProductsListRepository {

    fun getAllProductsFlow(): Flow<List<ProductDo>>

    suspend fun addProduct(product: ProductDo)

    suspend fun deleteProduct(productId: String)

    suspend fun updateProduct(productDo: ProductDo)
}
package com.example.core_shopping_api.repositories

import com.example.core_shopping_api.models.ProductDo
import kotlinx.coroutines.flow.Flow

/**
 * Репозиторий для работы с общим списком продуктов
 */
interface SharedProductsListRepository {

    fun getAllProductsFlow(): Flow<List<ProductDo>>

    suspend fun addProduct(product: ProductDo)

    suspend fun deleteProduct(productId: String)

    suspend fun setNewSearcherId(productId: String, newSearcherId: String?)
}
package com.hometech.core_shopping_impl.repositories

import com.example.core_shopping_api.models.ProductDo
import com.example.core_shopping_api.models.ProductDto
import com.example.core_shopping_api.repositories.SharedProductsListRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.hometech.core_shopping_impl.mapping.ProductDataMapping
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import ru.hometech.core_common.coroutines.DispatchersProvider
import javax.inject.Inject

class SharedProductsListRepositoryImpl @Inject constructor(
    private val remoteDb: FirebaseFirestore,
    private val productDataMapping: ProductDataMapping,
    private val dispatchers: DispatchersProvider,
) : SharedProductsListRepository {

    override fun getAllProductsFlow(): Flow<List<ProductDo>> =
        callbackFlow {
            val listener = remoteDb.collection("Products")
                .addSnapshotListener { value, _ ->
                    value?.let { snapshot ->
                        trySend(
                            snapshot.map { document ->
                                document.toObject(ProductDto::class.java)
                                    .copy(id = document.id).let { productDataMapping.toDo(it) }
                            }
                        )
                    }
                }
            awaitClose {
                listener.remove()
            }
        }

    override suspend fun addProduct(product: ProductDo) {
        withContext(dispatchers.io) {
            remoteDb.collection("Products")
                .add(productDataMapping.toDto(product))
                .await()
        }
    }

    override suspend fun deleteProduct(productId: String): Unit = withContext(dispatchers.io) {
        remoteDb.collection("Products")
            .document(productId)
            .delete().await()
    }

    override suspend fun updateProduct(productDo: ProductDo): Unit =
        withContext(dispatchers.io) {
            val productDto = productDataMapping.toDto(productDo)
            remoteDb.collection("Products")
                .document(productDto.id)
                .set(productDto)
                .await()
        }
}
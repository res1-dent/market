package com.hometech.core_shopping_impl.repositories

import com.example.core_shopping_api.models.ProductDo
import com.example.core_shopping_api.models.ProductDto
import com.example.core_shopping_api.models.toDo
import com.example.core_shopping_api.models.toDto
import com.example.core_shopping_api.repositories.SharedProductsListRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import ru.hometech.core_common.coroutines.DispatchersProvider
import javax.inject.Inject

class SharedProductsListRepositoryImpl @Inject constructor(
    private val remoteDb: FirebaseFirestore,
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
                                    .copy(id = document.id).toDo()
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
                .add(product.toDto())
                .await()
        }
    }

    override suspend fun deleteProduct(productId: String): Unit = withContext(dispatchers.io) {
        remoteDb.collection("Products")
            .document(productId)
            .delete().await()
    }

    override suspend fun setNewSearcherId(productId: String, newSearcherId: String?): Unit =
        withContext(dispatchers.io) {
            remoteDb.collection("Products")
                .document(productId)
                .update("searcherId", newSearcherId)
                .await()
        }
}
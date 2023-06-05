package ru.hometech.feature_shopping.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.util.UUID
import javax.inject.Inject

class ShoppingViewModel @Inject constructor() : ViewModel() {

    private val db = Firebase.firestore

    private val _state: MutableStateFlow<ShoppingState> = MutableStateFlow(ShoppingState.EMPTY)

    val state: StateFlow<ShoppingState> = _state.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getAllProductsFlow().onEach { products ->
                _state.update {
                    it.copy(products = products)
                }
            }.collect()
        }
    }


    private fun getAllProductsFlow(): Flow<List<Product>> = callbackFlow {
        val listener = db
            .collection("Products")
            .addSnapshotListener { value, _ ->
                value?.let {
                    trySend(it.map { ss ->
                        ss.toObject(Product::class.java).copy(id = ss.id)
                    })
                }
            }
        awaitClose {
            listener.remove()
        }
    }

    fun addProduct(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            db
                .collection("Products")
                .add(product)
                .await()
        }
    }

    fun deleteProduct(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            db
                .collection("Products")
                .document(id)
                .delete().await()
        }
    }
}


data class Product(
    val id: String = UUID.randomUUID().toString(),
    val name: String = ""
)

data class ShoppingState(
    val products: List<Product> = emptyList()
) {
    companion object {
        val EMPTY = ShoppingState()
    }
}
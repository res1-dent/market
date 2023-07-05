package ru.hometech.feature_shopping.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.hometech.core_common.BaseViewModel
import ru.hometech.core_common.IntentProcessor
import ru.hometech.feature_shopping.ui.state.ShoppingIntent
import ru.hometech.feature_shopping.ui.state.ShoppingViewState
import ru.hometech.feature_shopping.usecases.IntentHandler
import javax.inject.Inject


class TestViewModel @Inject constructor() : ViewModel()
class ShoppingViewModel @Inject constructor(
    private val intentHandler: IntentHandler
) : BaseViewModel<ShoppingViewState, ShoppingIntent>(ShoppingViewState.INITIAL) {
    init {
        viewModelScope.launch {
            submitIntent(ShoppingIntent.GetAllProductsFlow)
        }
    }

    override suspend fun processIntent(intent: ShoppingIntent) {

        when (intent) {
            is ShoppingIntent.AddProduct -> {
                intentHandler.handleAddProduct(intent.productUi)
            }

            is ShoppingIntent.UpdateSearcherId -> {
                intentHandler.handleUpdateSearcherId(
                    intent.productId,
                    intent.changeSearcherType
                )
            }

            is ShoppingIntent.DeleteProduct -> intentHandler.handleDeleteProduct(intent.id)
            ShoppingIntent.GetAllProductsFlow -> getAllProductsFlow()

        }
    }

    private fun getAllProductsFlow() {
        viewModelScope.launch {
            intentHandler.handleGetAllProductsFlow().collect { products ->
                _state.update {
                    it.copy(productList = products)
                }
            }
        }
    }
}
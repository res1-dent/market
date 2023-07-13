package ru.hometech.feature_shopping.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.hometech.core_common.BaseViewModel
import ru.hometech.core_common.IntentProcessor
import ru.hometech.core_common.coroutines.mapIterable
import ru.hometech.feature_shopping.models.ProductUi
import ru.hometech.feature_shopping.models.mapping.ProductUiMapping
import ru.hometech.feature_shopping.ui.state.ShoppingIntent
import ru.hometech.feature_shopping.ui.state.ShoppingViewState
import ru.hometech.feature_shopping.usecases.AddProduct
import ru.hometech.feature_shopping.usecases.DeleteProduct
import ru.hometech.feature_shopping.usecases.GetAllProductsFlow
import ru.hometech.feature_shopping.usecases.IntentHandler
import ru.hometech.feature_shopping.usecases.UpdateSearcherId
import javax.inject.Inject


class TestViewModel @Inject constructor() : ViewModel()
class ShoppingViewModel @Inject constructor(
    private val addProductUseCase: AddProduct,
    private val deleteProductUseCase: DeleteProduct,
    private val updateSearcherIdUserCase: UpdateSearcherId,
    private val getAllProductsFlowUseCase: GetAllProductsFlow,
    private val productMapper: ProductUiMapping
) : ViewModel() {

    private val _uiState = MutableStateFlow(ShoppingViewState.INITIAL)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getAllProductsFlow()
        }
    }

    fun onAddProduct(productUi: ProductUi) {
        viewModelScope.launch {
            addProductUseCase(productMapper.mapToDomain(productUi))
        }
    }

    fun deleteProductById(productId: String) {
        viewModelScope.launch {
            deleteProductUseCase(productId)
        }
    }


    private fun getAllProductsFlow() {
        viewModelScope.launch {
            getAllProductsFlowUseCase().mapIterable { productMapper.mapToUi(it) }
                .collect { products ->
                    _uiState.update {
                        it.copy(productList = products)
                    }
                }
        }
    }
}
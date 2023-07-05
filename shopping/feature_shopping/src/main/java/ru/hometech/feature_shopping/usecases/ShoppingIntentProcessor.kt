/*
package ru.hometech.feature_shopping.usecases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext
import ru.hometech.core_common.IntentProcessor
import ru.hometech.core_common.coroutines.mapIterable
import ru.hometech.core_common.di.PerFeature
import ru.hometech.feature_shopping.models.EnumChangeSearcherType
import ru.hometech.feature_shopping.models.ProductUi
import ru.hometech.feature_shopping.models.mapping.ProductUiMapping
import ru.hometech.feature_shopping.ui.state.ShoppingIntent
import ru.hometech.feature_shopping.ui.state.ShoppingViewState
import javax.inject.Inject

@PerFeature
class ShoppingIntentProcessor @Inject constructor(
    private val getAllProductsFlow: GetAllProductsFlow,
    private val addProductUseCase: AddProduct,
    private val deleteProductUseCase: DeleteProduct,
    private val updateSearcherIdUserCase: UpdateSearcherId,
    private val productMapper: ProductUiMapping
) : IntentProcessor<ShoppingViewState, ShoppingIntent> {

    override suspend fun processIntent(
        lastState: ShoppingViewState,
        intent: ShoppingIntent
    ): ShoppingViewState {
        return when (intent) {
            is ShoppingIntent.AddProduct -> handleAddProduct(lastState, intent.productUi)
            is ShoppingIntent.UpdateSearcherId -> handleUpdateSearcherId(
                lastState,
                intent.productId,
                intent.changeSearcherType
            )

            is ShoppingIntent.DeleteProduct -> handleDeleteProduct(lastState, intent.id)
            is ShoppingIntent.GetAllProductsFlow -> handleGetAllProductsFlow(lastState)
        }
    }

    private suspend fun handleAddProduct(
        lastState: ShoppingViewState,
        productUi: ProductUi
    ): ShoppingViewState =
        try {
            addProductUseCase(productMapper.mapToDomain(productUi))
            lastState.copy(error = null)
        } catch (e: Exception) {
            lastState.copy(isLoading = false, error = e.message)
        }

    private suspend fun handleUpdateSearcherId(
        lastState: ShoppingViewState,
        productId: String,
        changeSearcherType: EnumChangeSearcherType
    ): ShoppingViewState {
        updateSearcherIdUserCase(productId, changeSearcherType)
        return lastState.copy(error = null)
    }

    private suspend fun handleDeleteProduct(
        lastState: ShoppingViewState,
        id: String
    ): ShoppingViewState {
        deleteProductUseCase(id)
        return lastState.copy(error = null)
    }

    private fun handleGetAllProductsFlow(lastState: ShoppingViewState): Flow<ShoppingViewState> =
        getAllProductsFlow().mapIterable { productMapper.mapFromDomain(it) }.map {
            lastState.copy(isLoading = false, productList = it)
        }

}*/

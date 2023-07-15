package ru.hometech.feature_shopping.ui.state

import com.example.core_shopping_api.usecases.ShoppingUseCases
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import ru.hometech.core_common.SideEffect
import ru.hometech.core_common.coroutines.mapIterable
import ru.hometech.core_common.di.PerFeature
import ru.hometech.feature_shopping.models.ProductUi
import ru.hometech.feature_shopping.models.SearchingStatus
import ru.hometech.feature_shopping.models.mapping.ProductUiMapping
import ru.hometech.marketgotogether.R
import java.util.UUID
import javax.inject.Inject

@PerFeature
class ShoppingSideEffect @Inject constructor(
    private val addProductUseCase: ShoppingUseCases.AddProduct,
    private val deleteProductUseCase: ShoppingUseCases.DeleteProductById,
    private val getAllProductsFlowUseCase: ShoppingUseCases.GetAllProductsFlow,
    private val updateSearcherIdUseCase: ShoppingUseCases.UpdateProduct,
    private val productMapper: ProductUiMapping
) : SideEffect<ShoppingState, ShoppingAction> {

    override fun perform(
        state: ShoppingState,
        action: ShoppingAction
    ): Flow<ShoppingState> = flow {
        when (action) {
            is ShoppingAction.AddRandomProduct -> addProduct()
            is ShoppingAction.DeleteProduct -> deleteProduct(action.productId)
            is ShoppingAction.GetAllProductsFlow -> getAllProducts(state)
            is ShoppingAction.UpdateSearcherId -> updateSearcherId(
                state,
                action.productId,
                action.newSearchingStatus
            )
        }
    }

    private suspend fun updateSearcherId(
        state: ShoppingState,
        productId: String,
        newSearcherStatus: SearchingStatus
    ) {
        state.productList.find { it.id == productId }
            ?.copy(searchingStatus = newSearcherStatus)
            ?.let {
                updateSearcherIdUseCase(productMapper.toDo(it))
            }
    }

    private suspend fun addProduct() {
        val products = listOf(
            "Сухари",
            "Чипсы",
            "Кола",
            "Колбаса",
            "Вода",
            "Сиги"
        )
        val product = ProductUi(
            id = UUID.randomUUID().toString(),
            name = products.random(),
            extra = "Green",
            needAmount = 10,
            factAmount = 5,
            amountType = R.string.liters,
            searchingStatus = SearchingStatus.CurrentUser
        )
        addProductUseCase(productMapper.toDo(product))
    }


    private suspend fun deleteProduct(productId: String) =
        deleteProductUseCase(productId)


    private suspend fun FlowCollector<ShoppingState>.getAllProducts(state: ShoppingState) {
        getAllProductsFlowUseCase().mapIterable { productMapper.toUi(it) }.collect {
            val newState = state.copy(productList = it, isLoading = false)
            emit(newState)
        }
    }
}
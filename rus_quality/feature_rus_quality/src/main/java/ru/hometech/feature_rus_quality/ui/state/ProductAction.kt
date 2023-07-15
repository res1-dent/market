package ru.hometech.feature_rus_quality.ui.state

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import ru.hometech.core_common.Action
import ru.hometech.core_common.Reducer
import ru.hometech.core_common.SideEffect
import ru.hometech.core_common.State
import ru.hometech.core_common.di.PerFeature
import ru.hometech.core_rus_quality_api.models.Barcode
import ru.hometech.core_rus_quality_api.useCases.RusQualityUseCases
import ru.hometech.feature_rus_quality.ui.models.RusQualityProductUi
import ru.hometech.feature_rus_quality.ui.models.RusQualityProductUiMapper
import javax.inject.Inject

sealed class ProductInfoAction : Action {
    data class GetRusQualityProduct(val barcode: String) : ProductInfoAction()
}

sealed class ProductInfoState : State {
    object Initial : ProductInfoState()

    object Loading : ProductInfoState()

    data class Success(
        val productInfo: RusQualityProductUi
    ) : ProductInfoState()
}

@PerFeature
class ProductInfoReducer @Inject constructor() : Reducer<ProductInfoState, ProductInfoAction> {

    override fun reduce(state: ProductInfoState, action: ProductInfoAction): ProductInfoState {
        return when (action) {
            is ProductInfoAction.GetRusQualityProduct -> {
                if (state is ProductInfoState.Initial)
                    ProductInfoState.Loading
                else state
            }
        }
    }

}

@PerFeature
class ProductInfoSideEffect @Inject constructor(
    private val getRusQualityProductByBarcode: RusQualityUseCases.GetRusQualityProductByBarcode,
    private val rusQualityProductUiMapper: RusQualityProductUiMapper
) : SideEffect<ProductInfoState, ProductInfoAction> {

    override fun perform(
        state: ProductInfoState,
        action: ProductInfoAction
    ): Flow<ProductInfoState> = flow {
        when (action) {
            is ProductInfoAction.GetRusQualityProduct -> {
                getRusQualityProduct(action.barcode)
            }
        }
    }

    private suspend fun FlowCollector<ProductInfoState>.getRusQualityProduct(barcode: String) {
        val product =
            rusQualityProductUiMapper.toUi(getRusQualityProductByBarcode(Barcode(barcode)))
        val newState = ProductInfoState.Success(productInfo = product)
        emit(newState)
    }

}
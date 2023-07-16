package ru.hometech.feature_rus_quality.ui.state

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import ru.hometech.core_common.SideEffect
import ru.hometech.core_common.di.PerFeature
import ru.hometech.core_rus_quality_api.models.Barcode
import ru.hometech.core_rus_quality_api.useCases.RusQualityUseCases
import ru.hometech.feature_rus_quality.ui.models.RusQualityProductUiMapper
import javax.inject.Inject

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

            ProductInfoAction.ScanAnotherProduct -> {
                /*ignore*/
            }
        }
    }

    private suspend fun FlowCollector<ProductInfoState>.getRusQualityProduct(barcode: String) {
        val state = runCatching {
            val product =
                rusQualityProductUiMapper.toUi(getRusQualityProductByBarcode(Barcode(barcode)))
            ProductInfoState.Success(productInfo = product)
        }.getOrElse {
            ProductInfoState.Error("${it.message}: $barcode")
        }
        emit(state)
    }

}
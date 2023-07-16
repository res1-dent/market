package ru.hometech.feature_rus_quality.ui.state

import ru.hometech.core_common.Action
import ru.hometech.core_common.State
import ru.hometech.feature_rus_quality.ui.models.RusQualityProductUi

sealed class ProductInfoAction : Action {
    data class GetRusQualityProduct(val barcode: String) : ProductInfoAction()

    object ScanAnotherProduct: ProductInfoAction()
}

sealed class ProductInfoState : State {
    object Initial : ProductInfoState()

    object Loading : ProductInfoState()

    data class Success(
        val productInfo: RusQualityProductUi,
        val prosExpanded: Boolean = false,
        val consExpanded: Boolean = false
    ) : ProductInfoState()

    data class Error(
        val message: String
    ): ProductInfoState()
}


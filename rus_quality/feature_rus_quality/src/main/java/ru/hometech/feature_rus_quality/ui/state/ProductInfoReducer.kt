package ru.hometech.feature_rus_quality.ui.state

import ru.hometech.core_common.Reducer
import ru.hometech.core_common.di.PerFeature
import javax.inject.Inject

@PerFeature
class ProductInfoReducer @Inject constructor() : Reducer<ProductInfoState, ProductInfoAction> {

    override fun reduce(state: ProductInfoState, action: ProductInfoAction): ProductInfoState {
        return when (action) {
            is ProductInfoAction.GetRusQualityProduct -> {
                if (state is ProductInfoState.Initial)
                    ProductInfoState.Loading
                else state
            }

            ProductInfoAction.ScanAnotherProduct -> ProductInfoState.Initial
        }
    }

}
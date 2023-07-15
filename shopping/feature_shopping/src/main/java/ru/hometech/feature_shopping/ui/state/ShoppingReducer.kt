package ru.hometech.feature_shopping.ui.state

import ru.hometech.core_common.Reducer
import ru.hometech.core_common.di.PerFeature
import javax.inject.Inject

@PerFeature
class ShoppingReducer @Inject constructor() : Reducer<ShoppingState, ShoppingAction> {
    override fun reduce(state: ShoppingState, action: ShoppingAction): ShoppingState {
        return when (action) {
            ShoppingAction.AddRandomProduct -> state.copy(isLoading = true)
            is ShoppingAction.DeleteProduct -> state.copy(isLoading = true)
            ShoppingAction.GetAllProductsFlow -> state.copy(isLoading = true)
            is ShoppingAction.UpdateSearcherId -> state.copy(isLoading = true)
        }
    }
}
package ru.hometech.feature_shopping.ui

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.hometech.core_common.BaseViewModel
import ru.hometech.core_network_api.repositories.RusQualityRepository
import ru.hometech.feature_shopping.ui.state.ShoppingAction
import ru.hometech.feature_shopping.ui.state.ShoppingReducer
import ru.hometech.feature_shopping.ui.state.ShoppingSideEffect
import ru.hometech.feature_shopping.ui.state.ShoppingState
import javax.inject.Inject

class ShoppingViewModel @Inject constructor(
    reducer: ShoppingReducer,
    sideEffect: ShoppingSideEffect,
    private val repository: RusQualityRepository
) : BaseViewModel<ShoppingState, ShoppingAction>(
    reducer = reducer,
    sideEffect = sideEffect,
    initialState = ShoppingState.INITIAL
) {
    init {
        viewModelScope.launch {
            repository.getProductByBarcode("4601916006276")
        }
       dispatch(ShoppingAction.GetAllProductsFlow)
    }
}
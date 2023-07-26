package ru.hometech.feature_shopping.ui

import ru.hometech.core_common.BaseViewModel
import ru.hometech.feature_shopping.ui.state.ShoppingAction
import ru.hometech.feature_shopping.ui.state.ShoppingReducer
import ru.hometech.feature_shopping.ui.state.ShoppingSideEffect
import ru.hometech.feature_shopping.ui.state.ShoppingState
import javax.inject.Inject

class ShoppingViewModel @Inject constructor(
    reducer: ShoppingReducer,
    sideEffect: ShoppingSideEffect,
) : BaseViewModel<ShoppingState, ShoppingAction>(
    reducer = reducer,
    sideEffect = sideEffect,
    initialState = ShoppingState.INITIAL
) {
    init {
       dispatch(ShoppingAction.GetAllProductsFlow)
    }
}
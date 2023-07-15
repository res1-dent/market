package ru.hometech.feature_rus_quality.ui

import ru.hometech.core_common.BaseViewModel
import ru.hometech.feature_rus_quality.ui.state.ProductInfoAction
import ru.hometech.feature_rus_quality.ui.state.ProductInfoReducer
import ru.hometech.feature_rus_quality.ui.state.ProductInfoSideEffect
import ru.hometech.feature_rus_quality.ui.state.ProductInfoState
import javax.inject.Inject


class ProductInfoViewModel @Inject constructor(
    reducer: ProductInfoReducer,
    sideEffect: ProductInfoSideEffect
) : BaseViewModel<ProductInfoState, ProductInfoAction>(reducer, sideEffect, ProductInfoState.Initial)
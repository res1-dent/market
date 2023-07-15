package ru.hometech.feature_shopping.ui.state

import ru.hometech.core_common.State
import ru.hometech.feature_shopping.models.ProductUi

@androidx.compose.runtime.Immutable
data class ShoppingState(
    val productList: List<ProductUi> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) : State {
    companion object {
        val INITIAL = ShoppingState()
    }
}
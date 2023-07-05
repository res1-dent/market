package ru.hometech.feature_shopping.ui.state

import ru.hometech.feature_shopping.models.ProductUi

data class ShoppingViewState(
    val productList: List<ProductUi> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null
) {
    companion object {
        val INITIAL = ShoppingViewState()
    }
}
package ru.hometech.feature_shopping.ui.state

import ru.hometech.feature_shopping.models.EnumChangeSearcherType
import ru.hometech.feature_shopping.models.ProductUi

sealed class ShoppingIntent {

    object GetAllProductsFlow : ShoppingIntent()
    data class AddProduct(val productUi: ProductUi) : ShoppingIntent()
    data class UpdateSearcherId(
        val productId: String,
        val changeSearcherType: EnumChangeSearcherType
    ) : ShoppingIntent()

    data class DeleteProduct(val id: String) : ShoppingIntent()
}
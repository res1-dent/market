package ru.hometech.feature_shopping.ui.state

import com.google.errorprone.annotations.Immutable
import ru.hometech.core_common.Action
import ru.hometech.feature_shopping.models.ProductUi
import ru.hometech.feature_shopping.models.SearchingStatus

/**
 * Экшены для экрана со списком покупок
 */
@Immutable
sealed class ShoppingAction : Action {
    object AddRandomProduct: ShoppingAction()
    data class DeleteProduct(val productId: String) : ShoppingAction()
    data class UpdateSearcherId(val productId: String, val newSearchingStatus: SearchingStatus): ShoppingAction()
    object GetAllProductsFlow : ShoppingAction()
}
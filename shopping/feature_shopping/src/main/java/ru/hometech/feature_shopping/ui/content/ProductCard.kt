package ru.hometech.feature_shopping.ui.content

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.hometech.core_common.obtainViewModel
import ru.hometech.feature_shopping.models.EnumChangeSearcherType
import ru.hometech.feature_shopping.models.ProductUi
import ru.hometech.feature_shopping.models.SearchingStatus
import ru.hometech.feature_shopping.ui.ShoppingViewModel
import ru.hometech.feature_shopping.ui.state.ShoppingIntent
import ru.hometech.marketgotogether.R

@Composable
fun ProductCard(
    productUi: ProductUi
) {
    val viewModel: ShoppingViewModel = obtainViewModel()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                viewModel.submitIntent(
                    ShoppingIntent.UpdateSearcherId(
                        productUi.id,
                        EnumChangeSearcherType
                            .values()
                            .random()
                    )
                )
            }
    ) {
        Text(productUi.name)
        Text(text = productUi.extra)
        Text(text = "Кол-во = ${productUi.needAmount} " + stringResource(id = productUi.amountType))
        Text(text = "Имеется: ${productUi.factAmount} " + stringResource(id = productUi.amountType))
        when (productUi.searchingStatus) {
            is SearchingStatus.AnotherUser -> Text(text = "Ищет ${productUi.searchingStatus}")
            SearchingStatus.CurrentUser -> Text(text = "Я ищу")
            SearchingStatus.None -> Text(text = "Никто не ищет")
        }
        IconButton(onClick = {
            viewModel.submitIntent(ShoppingIntent.DeleteProduct(productUi.id))
        }) {
            Icon(imageVector = Icons.Filled.Delete, contentDescription = null)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    val productUi = ProductUi(
        id = "1",
        name = "Молоко",
        extra = "Жирность 15%",
        needAmount = 2,
        factAmount = 1,
        amountType = R.string.liters,
        searchingStatus = SearchingStatus.None
    )
    //ProductCard(product, )
}





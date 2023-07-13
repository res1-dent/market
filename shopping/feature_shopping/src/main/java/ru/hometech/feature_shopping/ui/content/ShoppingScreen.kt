package ru.hometech.feature_shopping.ui.content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.hometech.core_common.obtainViewModel
import ru.hometech.feature_shopping.models.ProductUi
import ru.hometech.feature_shopping.models.SearchingStatus
import ru.hometech.feature_shopping.ui.state.ShoppingIntent
import ru.hometech.feature_shopping.ui.ShoppingViewModel
import ru.hometech.feature_shopping.ui.state.ShoppingViewState
import ru.hometech.marketgotogether.R
import java.util.UUID

@Composable
fun ShoppingScreen() {
    val viewModel: ShoppingViewModel = obtainViewModel()
    val viewState: ShoppingViewState by viewModel.uiState.collectAsState()
    Box(modifier = Modifier.fillMaxSize()) {
        val modifier = Modifier
            .align(Alignment.TopCenter)
            .fillMaxWidth()
        LazyColumn(modifier) {
            items(viewState.productList) { product ->
                ProductCard(productUi = product)
            }
        }
        Button(
            onClick = {
                viewModel.onAddProduct(generateProduct())
            },
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Text(text = "Добавить рандомный")
        }
    }
}

fun generateProduct(): ProductUi {
    val products = listOf(
        "Сухари",
        "Чипсы",
        "Кола",
        "Колбаса",
        "Вода",
        "Сиги"
    )
    val productUi = ProductUi(
        id = UUID.randomUUID().toString(),
        name = products.random(),
        extra = "Green",
        needAmount = 10,
        factAmount = 5,
        amountType = R.string.liters,
        searchingStatus = SearchingStatus.CurrentUser
    )
    return productUi
}
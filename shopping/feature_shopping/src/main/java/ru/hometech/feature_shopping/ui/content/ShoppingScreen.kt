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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.hometech.feature_shopping.models.ProductUi
import ru.hometech.feature_shopping.models.SearchingStatus
import ru.hometech.feature_shopping.ui.ShoppingViewModel
import ru.hometech.feature_shopping.ui.state.ShoppingState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import ru.hometech.feature_shopping.ui.state.ShoppingAction
import ru.hometech.marketgotogether.R
import java.util.UUID

@Composable
fun ShoppingScreen(viewModel: ShoppingViewModel) {
    val viewState: ShoppingState by viewModel.uiState.collectAsState()
    ShoppingScreen(viewState = viewState, viewModel::dispatch)
}

@Composable
fun ShoppingScreen(
    viewState: ShoppingState,
    onDispatch: (ShoppingAction) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
        ) {
            items(viewState.productList, key = { it.id }) { product ->
                ProductCard(productUi = product, dispatch = onDispatch)
            }
        }
        val addRandomProduct: () -> Unit = remember {
            {
                onDispatch(ShoppingAction.AddRandomProduct)
            }
        }
        Button(
            onClick = addRandomProduct,
            modifier =  Modifier.align(Alignment.BottomCenter)
        ) {
            Text(text = "Добавить рандомный")
        }
    }
}


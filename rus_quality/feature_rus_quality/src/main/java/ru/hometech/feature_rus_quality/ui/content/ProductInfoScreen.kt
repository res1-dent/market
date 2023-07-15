package ru.hometech.feature_rus_quality.ui.content

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import ru.hometech.feature_rus_quality.ui.ProductInfoViewModel
import ru.hometech.feature_rus_quality.ui.state.ProductInfoAction
import ru.hometech.feature_rus_quality.ui.state.ProductInfoState


@Composable
fun ProductInfoScreen(state: ProductInfoState, onDispatch: (ProductInfoAction) -> Unit) {
    onDispatch(ProductInfoAction.GetRusQualityProduct("4607036521828"))
    when (state) {
        ProductInfoState.Initial -> {
            Text(text = "Initial")
        }
        ProductInfoState.Loading -> {
            Text(text = "Loading")
        }
        is ProductInfoState.Success -> {
            Text(text = state.productInfo.toString())
        }
    }

}
package ru.hometech.feature_rus_quality.ui.content

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ru.hometech.feature_rus_quality.ui.ProductInfoViewModel
import ru.hometech.feature_rus_quality.ui.state.ProductInfoAction
import ru.hometech.feature_rus_quality.ui.state.ProductInfoState
import ru.hometech.marketgotogether.R


@Composable
fun ProductInfoScreen(state: ProductInfoState, onDispatch: (ProductInfoAction) -> Unit) {
    LaunchedEffect(key1 = true) {
        onDispatch(ProductInfoAction.GetRusQualityProduct("4607036521828"))
    }
    when (state) {
        ProductInfoState.Initial -> {
            Text(text = "Initial")
        }
        ProductInfoState.Loading -> {
            Text(text = "Loading")
        }
        is ProductInfoState.Success -> {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(state.productInfo.thumbnail)
                    .crossfade(true)
                    .build(),
                placeholder = null,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxWidth()
            )
            //Text(text = state.productInfo.toString())
        }
    }

}
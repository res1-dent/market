package ru.hometech.feature_rus_quality.ui.content

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ru.hometech.core_common.ui.CameraPreview
import ru.hometech.feature_rus_quality.ui.models.RusQualityProductUi
import ru.hometech.feature_rus_quality.ui.state.ProductInfoAction
import ru.hometech.feature_rus_quality.ui.state.ProductInfoState


@Composable
fun ProductInfoScreen(state: ProductInfoState, onDispatch: (ProductInfoAction) -> Unit) {
    Column(Modifier.fillMaxSize()) {

        when (state) {
            ProductInfoState.Initial -> {
                CameraPreview(
                    modifier = Modifier.fillMaxSize()
                ) {
                    onDispatch(ProductInfoAction.GetRusQualityProduct(it))
                }
            }

            ProductInfoState.Loading -> {
                Text(text = "Loading")
            }

            is ProductInfoState.Success -> {
                ProductInfo(product = state.productInfo, onDispatch)
            }

            is ProductInfoState.Error -> {
                Text(text = state.message)
                Button(onClick = { onDispatch(ProductInfoAction.ScanAnotherProduct) }) {
                    Text("Сканим ещё")
                }
            }
        }
    }
}

@Composable
fun ProductInfo(product: RusQualityProductUi, onDispatch: (ProductInfoAction) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        item(product.thumbnail) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.thumbnail)
                    .crossfade(true)
                    .build(),
                placeholder = null,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clip(RoundedCornerShape(15))
            )
        }
        item(product.title) {
            TitleText(
                title = product.title,
            )
        }
        items(product.productInfo) {
            ProductInfo(it.name, it.value)
        }
        item {
            ProsAndCons(
                pros = product.worth,
                cons = product.disadvantage,
            )
        }

        item {
            Button(onClick = { onDispatch(ProductInfoAction.ScanAnotherProduct) }) {
                Text("Сканим ещё")
            }
        }
    }
}

@Composable
fun TitleText(title: String) {
    Text(
        text = title,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Left
    )
}

@Composable
fun ProductInfo(title: String, value: String) {
    Column {
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left
        )
        Text(
            text = value,
            fontSize = 14.sp,
            textAlign = TextAlign.Left
        )
    }
}

@Composable
fun ProsAndCons(
    pros: List<String>,
    cons: List<String>
) {
    pros.forEach {
        Text(text = it, color = Color.Green)
    }
    cons.forEach {
        Text(text = it, color = Color.Red)
    }
}
package ru.hometech.feature_shopping.ui.content

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.hometech.core_common.daggerViewModel
import ru.hometech.feature_shopping.ui.Product
import ru.hometech.feature_shopping.ui.ShoppingViewModel
import ru.hometech.feature_shopping.ui.di.ShoppingComponent

@Composable
fun ShoppingScreen(viewModel: ShoppingViewModel) {
    val uiState by viewModel.state.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .padding(bottom = 100.dp)
        ) {
            items(uiState.products) {
                Text(text = it.name, modifier = Modifier.clickable {
                    viewModel.deleteProduct(it.id)
                }, fontSize = 50.sp)
            }
        }
        Button(onClick = {
            viewModel.addProduct(generateProduct())
        }, modifier = Modifier.align(Alignment.BottomCenter)) {
            Text(text = "Добавить рандомный")
        }

    }
}

fun generateProduct(): Product {
    val products = listOf(
        "Сухари",
        "Чипсы",
        "Кола",
        "Колбаса",
        "Вода",
        "Сиги"
    )
    return Product(name = products.random())
}
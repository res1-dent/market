package ru.hometech.feature_shopping.ui.content

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.hometech.feature_shopping.models.ProductUi
import ru.hometech.feature_shopping.models.SearchingStatus
import ru.hometech.feature_shopping.ui.state.ShoppingAction

@Composable
fun ProductCard(
    productUi: ProductUi,
    dispatch: (action: ShoppingAction) -> Unit
) {
    Row {
        Column(
            modifier = Modifier
                .weight(1f)
                .clickable {
                    dispatch(
                        ShoppingAction.UpdateSearcherId(
                            productUi.id,
                            SearchingStatus.CurrentUser
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
            IconButton(
                onClick = remember(productUi.id) {
                    {
                        dispatch(ShoppingAction.DeleteProduct(productUi.id))
                    }
                }
            ) {
                Icon(imageVector = Icons.Filled.Delete, contentDescription = null)
            }
        }

    }
}




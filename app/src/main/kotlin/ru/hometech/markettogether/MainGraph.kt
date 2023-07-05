package ru.hometech.markettogether

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import ru.hometech.core_common.NavigationDestination
import ru.hometech.marketgotogether.R

sealed class MainGraph(destination: String): NavigationDestination(destination) {
    object ShoppingScreen : MainGraph("ShoppingScreen")
}

sealed class Screen(val destination: NavigationDestination, @StringRes val resourceId: Int, val icon: ImageVector) {

    object Shopping : Screen(MainGraph.ShoppingScreen, R.string.shopping, Icons.Filled.ShoppingCart)
}
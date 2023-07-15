package ru.hometech.markettogether.ui

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import ru.hometech.core_common.NavigationDestination
import ru.hometech.marketgotogether.R

sealed class MainGraph(destination: String): NavigationDestination(destination) {
    object ShoppingScreen : MainGraph("ShoppingScreen")
    object RusQualityScreen: MainGraph("RusQualityScreen")
}

sealed class Screen(val destination: NavigationDestination, @StringRes val resourceId: Int, val icon: ImageVector) {

    object Shopping : Screen(MainGraph.ShoppingScreen, R.string.shopping, Icons.Filled.ShoppingCart)

    object RusQuality: Screen(MainGraph.RusQualityScreen, R.string.rusQuality, Icons.Filled.Star)
}
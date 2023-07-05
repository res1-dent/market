package ru.hometech.feature_shopping.navigation

import ru.hometech.core_common.NavigationDestination

sealed class ShoppingGraph(route: String) : NavigationDestination(route) {
    object ProductList: ShoppingGraph("ProductList")
    object AddProduct: ShoppingGraph("AddProduct")
}
package ru.hometech.feature_shopping.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.hometech.core_common.addObserver
import ru.hometech.core_common.createScreenWithDaggerViewModel
import ru.hometech.feature_shopping.di.ShoppingComponent
import ru.hometech.feature_shopping.ui.ShoppingViewModel
import ru.hometech.feature_shopping.ui.content.ShoppingScreen

fun NavGraphBuilder.shoppingGraph(navController: NavController, route: String) {
    navigation(startDestination = ShoppingGraph.ProductList.route, route = route) {
        composable(route = ShoppingGraph.ProductList.route) { navBackStackEntry ->
            navBackStackEntry.addObserver(ShoppingComponent::release)
            createScreenWithDaggerViewModel<ShoppingComponent, ShoppingViewModel>(
                component = ShoppingComponent.getOrCreate()
            ) {
                ShoppingScreen()
            }
        }
    }
}
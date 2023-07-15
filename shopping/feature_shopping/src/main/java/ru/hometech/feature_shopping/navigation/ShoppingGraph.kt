package ru.hometech.feature_shopping.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.hometech.core_common.addObserver
import ru.hometech.core_common.createMviScreen
import ru.hometech.core_common.createScreenWithDaggerMviViewModel
import ru.hometech.feature_shopping.di.ShoppingComponent
import ru.hometech.feature_shopping.ui.state.ShoppingAction
import ru.hometech.feature_shopping.ui.ShoppingViewModel
import ru.hometech.feature_shopping.ui.content.ShoppingScreen
import ru.hometech.feature_shopping.ui.state.ShoppingState

fun NavGraphBuilder.shoppingGraph(navController: NavController, route: String) {
    navigation(startDestination = ShoppingGraph.ProductList.route, route = route) {
        composable(route = ShoppingGraph.ProductList.route) { navBackStackEntry ->
            navBackStackEntry.addObserver(ShoppingComponent::release)
            createMviScreen<ShoppingComponent, ShoppingViewModel, ShoppingAction, ShoppingState>(
                component = ShoppingComponent.getOrCreate()
            ) { state, onDispatch ->
                ShoppingScreen(state, onDispatch)
            }
        }
    }
}
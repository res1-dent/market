package ru.hometech.feature_rus_quality.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.hometech.core_common.addObserver
import ru.hometech.core_common.createMviScreen
import ru.hometech.core_common.createScreenWithDaggerMviViewModel
import ru.hometech.feature_rus_quality.di.RusQualityComponent
import ru.hometech.feature_rus_quality.ui.ProductInfoViewModel
import ru.hometech.feature_rus_quality.ui.content.ProductInfoScreen
import ru.hometech.feature_rus_quality.ui.state.ProductInfoAction
import ru.hometech.feature_rus_quality.ui.state.ProductInfoState

fun NavGraphBuilder.rusQualityGraph(navController: NavController, route: String) {
    navigation(startDestination = RusQualityGraph.RusQualityProduct.route, route = route) {
        composable(route = RusQualityGraph.RusQualityProduct.route) { navBackStackEntry ->
            navBackStackEntry.addObserver(RusQualityComponent::release)
            createMviScreen<RusQualityComponent, ProductInfoViewModel, ProductInfoAction, ProductInfoState>(
                component = RusQualityComponent.getOrCreate(),
            ) { state, onDispatch ->
                ProductInfoScreen(state, onDispatch)
            }
        }
    }
}
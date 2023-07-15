package ru.hometech.feature_rus_quality.navigation

import ru.hometech.core_common.NavigationDestination

sealed class RusQualityGraph(route: String) : NavigationDestination(route) {
    object RusQualityProduct: RusQualityGraph("RusQualityProduct")
}
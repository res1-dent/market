package ru.hometech.markettogether

sealed class NavigationDestination(val destination: String) {
    object MainScreen : NavigationDestination("MainScreen")
    object ShoppingScreen : NavigationDestination("ShoppingScreen")
}
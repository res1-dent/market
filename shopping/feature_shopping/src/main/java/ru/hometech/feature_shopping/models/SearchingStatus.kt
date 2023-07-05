package ru.hometech.feature_shopping.models

sealed class SearchingStatus {
    object None : SearchingStatus()
    object CurrentUser : SearchingStatus()
    data class AnotherUser(val name: String) : SearchingStatus()
}
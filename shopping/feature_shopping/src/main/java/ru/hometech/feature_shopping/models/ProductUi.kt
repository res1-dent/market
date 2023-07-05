package ru.hometech.feature_shopping.models

import androidx.annotation.StringRes


data class ProductUi(
    val id: String,
    val name: String,
    val extra: String,
    val needAmount: Int,
    val factAmount: Int,
    @StringRes val amountType: Int,
    val searchingStatus: SearchingStatus
)


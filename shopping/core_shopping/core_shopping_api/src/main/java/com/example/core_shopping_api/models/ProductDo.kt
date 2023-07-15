package com.example.core_shopping_api.models

data class ProductDo(
    val id: String,
    val name: String,
    val extra: String,
    val amount: Int,
    val factAmount: Int,
    val amountType: EnumAmountType,
    val searcherId: String?,
)
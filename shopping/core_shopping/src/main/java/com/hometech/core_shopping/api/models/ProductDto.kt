package com.hometech.core_shopping.api.models

import java.util.UUID

data class ProductDto(
    val id: String = UUID.randomUUID().toString(),
    val name: String = "",
    val extra: String = "",
    val amount: Int = 0,
    val factAmount: Int = 0,
    val amountType: Int = 1,
    val searcherId: String? = null
)



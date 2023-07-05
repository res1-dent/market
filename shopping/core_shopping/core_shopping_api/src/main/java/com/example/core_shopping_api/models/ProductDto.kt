package com.example.core_shopping_api.models

import java.util.Date
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

enum class EnumAmountType(val value: Int) {
    KG(1), LITERS(2), UNIT(3), UNKNOWN(-1);

    companion object {
        fun fromIntValue(intValue: Int): EnumAmountType {
            return checkNotNull(values().find { it.value == intValue }) {
                "EnumAmountType для $intValue не найден"
            }
        }
    }
}

data class ProductDo(
    val id: String,
    val name: String,
    val extra: String,
    val amount: Int,
    val factAmount: Int,
    val amountType: EnumAmountType,
    val searcherId: String?,
)

fun ProductDto.toDo(): ProductDo = ProductDo(
    id = id,
    name = name,
    extra = extra,
    amount = amount,
    factAmount = factAmount,
    amountType = EnumAmountType.fromIntValue(amountType),
    searcherId = searcherId
)

fun ProductDo.toDto(): ProductDto = ProductDto(
    id = id,
    name = name,
    extra = extra,
    amount = amount,
    factAmount = factAmount,
    amountType = amountType.value,
    searcherId = searcherId
)



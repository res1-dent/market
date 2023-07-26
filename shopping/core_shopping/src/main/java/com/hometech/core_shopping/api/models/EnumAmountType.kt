package com.hometech.core_shopping.api.models

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
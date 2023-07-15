package ru.hometech.core_network_api.repositories

import ru.hometech.core_network_api.models.RusQualityProductDTOI

interface RusQualityRepository {
    suspend fun getProductByBarcode(barcode: String): RusQualityProductDTOI
}
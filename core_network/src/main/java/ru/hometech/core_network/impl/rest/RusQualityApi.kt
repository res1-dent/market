package ru.hometech.core_network.impl.rest

import retrofit2.http.GET
import retrofit2.http.Query
import ru.hometech.core_network.impl.Constants.RusQuality.barcodeQuery
import ru.hometech.core_network.impl.Constants.RusQuality.searchByBarcodeRoute

internal interface RusQualityApi {

    @GET(searchByBarcodeRoute)
    suspend fun searchBarcode(@Query(barcodeQuery) barcode: String): ru.hometech.core_network.api.models.RusQualityProductDTOI
}
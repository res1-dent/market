package ru.hometech.core_network_impl.rest

import retrofit2.http.GET
import retrofit2.http.Query
import ru.hometech.core_network_impl.Constants.RusQuality.barcodeQuery
import ru.hometech.core_network_impl.Constants.RusQuality.searchByBarcodeRoute
import ru.hometech.core_network_api.models.RusQualityProductDTOI

interface RusQualityApi {

    @GET(searchByBarcodeRoute)
    suspend fun searchBarcode(@Query(barcodeQuery) barcode: String): RusQualityProductDTOI
}
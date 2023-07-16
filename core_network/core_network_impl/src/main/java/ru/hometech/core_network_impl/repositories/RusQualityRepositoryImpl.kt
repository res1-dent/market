package ru.hometech.core_network_impl.repositories

import kotlinx.coroutines.withContext
import ru.hometech.core_common.coroutines.DispatchersProvider
import ru.hometech.core_network_api.exceptions.RusQualityProductNotFound
import ru.hometech.core_network_api.models.RusQualityProductDTOI
import ru.hometech.core_network_api.repositories.RusQualityRepository
import ru.hometech.core_network_impl.rest.RusQualityApi
import javax.inject.Inject

class RusQualityRepositoryImpl @Inject constructor(
    private val rusQualityApi: RusQualityApi,
    private val dispatchersProvider: DispatchersProvider
) : RusQualityRepository {

    override suspend fun getProductByBarcode(barcode: String): RusQualityProductDTOI =
        withContext(dispatchersProvider.io) {
            rusQualityApi.searchBarcode(barcode).also {
                it.rusQualityProductResponseDTOI.id ?: throw RusQualityProductNotFound()
            }
        }
}
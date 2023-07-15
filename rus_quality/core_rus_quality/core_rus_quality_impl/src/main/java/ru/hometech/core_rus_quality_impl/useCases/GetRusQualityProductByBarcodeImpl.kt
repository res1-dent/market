package ru.hometech.core_rus_quality_impl.useCases

import ru.hometech.core_common.di.PerFeature
import ru.hometech.core_network_api.repositories.RusQualityRepository
import ru.hometech.core_rus_quality_api.models.Barcode
import ru.hometech.core_rus_quality_api.models.RusQualityProductDO
import ru.hometech.core_rus_quality_api.useCases.RusQualityUseCases
import ru.hometech.core_rus_quality_impl.mapping.RosQualityProductDataMapper
import javax.inject.Inject

@PerFeature
class GetRusQualityProductByBarcodeImpl @Inject constructor(
    private val rusQualityRepository: RusQualityRepository,
    private val rusQualityProductMapper: RosQualityProductDataMapper
) : RusQualityUseCases.GetRusQualityProductByBarcode {
    override suspend fun invoke(params: Barcode): RusQualityProductDO {
        val product = rusQualityRepository.getProductByBarcode(params.value)
        return rusQualityProductMapper.toDo(product)
    }
}
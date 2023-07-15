package ru.hometech.core_rus_quality_api.useCases

import ru.hometech.core_common.usecases.UseCase
import ru.hometech.core_rus_quality_api.models.Barcode
import ru.hometech.core_rus_quality_api.models.RusQualityProductDO

object RusQualityUseCases {

    interface GetRusQualityProductByBarcode: UseCase<Barcode, RusQualityProductDO>

}
package ru.hometech.core_rus_quality_impl.mapping

import ru.hometech.core_common.DataMapper
import ru.hometech.core_common.di.PerFeature
import ru.hometech.core_network_api.models.ProductInfoDTOI
import ru.hometech.core_network_api.models.ResearchDTOI
import ru.hometech.core_network_api.models.RusQualityProductDTOI
import ru.hometech.core_network_api.models.RusQualityProductResponseDTOI
import ru.hometech.core_rus_quality_api.models.ProductInfoDo
import ru.hometech.core_rus_quality_api.models.ResearchDO
import ru.hometech.core_rus_quality_api.models.RusQualityProductDO
import javax.inject.Inject

@PerFeature
class RosQualityProductDataMapper @Inject constructor() :
    DataMapper<RusQualityProductDO, RusQualityProductResponseDTOI> {

    override fun toDo(dataModel: RusQualityProductResponseDTOI): RusQualityProductDO =
        with(dataModel) {
            RusQualityProductDO(
                id = id,
                title = title,
                totalRating = totalRating,
                productLink = productLink,
                categoryName = categoryName,
                manufacturer = manufacturer,
                research = ResearchDO(
                    id = researchDTOI.id,
                    title = researchDTOI.title,
                    productGroup = researchDTOI.productGroup,
                    image = researchDTOI.image,
                    date = researchDTOI.date
                ),
                worth = worth,
                disadvantage = disadvantage,
                thumbnail = thumbnail,
                price = price,
                productInfo = productInfoDTOI.map { it.toDo() }
            )
        }

    private fun ProductInfoDTOI.toDo(): ProductInfoDo = ProductInfoDo(name, value)

    private fun ProductInfoDo.toData(): ProductInfoDTOI = ProductInfoDTOI(name, value)

    override fun toDto(domainModel: RusQualityProductDO): RusQualityProductResponseDTOI =
        with(domainModel) {
            RusQualityProductResponseDTOI(
                    id = id,
                    title = title,
                    totalRating = totalRating,
                    productLink = productLink,
                    categoryName = categoryName,
                    manufacturer = manufacturer,
                    researchDTOI = ResearchDTOI(
                        id = research.id,
                        title = research.title,
                        productGroup = research.productGroup,
                        image = research.image,
                        date = research.date
                    ),
                    worth = worth,
                    disadvantage = disadvantage,
                    thumbnail = thumbnail,
                    price = price,
                    productInfoDTOI = productInfo.map { it.toData() }

            )
        }
}
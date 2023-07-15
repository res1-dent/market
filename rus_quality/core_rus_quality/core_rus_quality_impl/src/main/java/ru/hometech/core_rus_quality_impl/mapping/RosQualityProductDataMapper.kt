package ru.hometech.core_rus_quality_impl.mapping

import ru.hometech.core_common.DataMapper
import ru.hometech.core_common.di.PerFeature
import ru.hometech.core_network_api.models.ResearchDTOI
import ru.hometech.core_network_api.models.RusQualityProductDTOI
import ru.hometech.core_network_api.models.RusQualityProductResponseDTOI
import ru.hometech.core_rus_quality_api.models.ResearchDO
import ru.hometech.core_rus_quality_api.models.RusQualityProductDO
import javax.inject.Inject

@PerFeature
class RosQualityProductDataMapper @Inject constructor() :
    DataMapper<RusQualityProductDO, RusQualityProductDTOI> {

    override fun toDo(dataModel: RusQualityProductDTOI): RusQualityProductDO =
        with(dataModel.rusQualityProductResponseDTOI) {
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
                    productGroup = researchDTOI.product_group,
                    image = researchDTOI.image,
                    date = researchDTOI.date
                ),
                worth = worth,
                disadvantage = disadvantage,
                thumbnail = thumbnail,
                price = price
            )
        }

    override fun toDto(domainModel: RusQualityProductDO): RusQualityProductDTOI =
        with(domainModel) {
            RusQualityProductDTOI(
                rusQualityProductResponseDTOI = RusQualityProductResponseDTOI(
                    id = id,
                    title = title,
                    totalRating = totalRating,
                    productLink = productLink,
                    categoryName = categoryName,
                    manufacturer = manufacturer,
                    researchDTOI = ResearchDTOI(
                        id = research.id,
                        title = research.title,
                        product_group = research.productGroup,
                        image = research.image,
                        date = research.date
                    ),
                    worth = worth,
                    disadvantage = disadvantage,
                    thumbnail = thumbnail,
                    price = price
                )
            )
        }
}
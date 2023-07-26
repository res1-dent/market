package ru.hometech.feature_rus_quality.ui.models

import ru.hometech.core_common.UiMapper
import ru.hometech.core_common.di.PerFeature
import ru.hometech.core_network.api.models.ProductInfoDTOI
import ru.hometech.core_rus_quality_api.models.ProductInfoDo
import ru.hometech.core_rus_quality_api.models.ResearchDO
import ru.hometech.core_rus_quality_api.models.RusQualityProductDO
import javax.inject.Inject

@PerFeature
class RusQualityProductUiMapper @Inject constructor() : UiMapper<RusQualityProductUi, RusQualityProductDO>{

    override fun toDo(uiModel: RusQualityProductUi): RusQualityProductDO = with(uiModel){
        return RusQualityProductDO(
            id = id,
            title = title,
            totalRating = totalRating,
            productLink = productLink,
            categoryName = categoryName,
            manufacturer = manufacturer,
            research = ResearchDO(
                research.id,
                research.title,
                research.productGroup,
                research.image,
                research.date
            ),
            worth = worth,
            disadvantage = disadvantage,
            thumbnail = thumbnail,
            price = price,
            productInfo = productInfo.map { it.toDo() }
        )
    }

    private fun ProductInfoDo.toUi(): ProductInfoUi = ProductInfoUi(name, value)

    private fun ProductInfoUi.toDo(): ProductInfoDo = ProductInfoDo(name, value)

    override fun toUi(domainModel: RusQualityProductDO): RusQualityProductUi = with(domainModel) {
        return RusQualityProductUi(
            id = id,
            title = title,
            totalRating = totalRating,
            productLink = productLink,
            categoryName = categoryName,
            manufacturer = manufacturer,
            research = ResearchUi(
                research.id,
                research.title,
                research.productGroup,
                research.image,
                research.date
            ),
            worth = worth.orEmpty(),
            disadvantage = disadvantage.orEmpty(),
            thumbnail = thumbnail,
            price = price,
            productInfo = productInfo.map { it.toUi() }
        )
    }
}
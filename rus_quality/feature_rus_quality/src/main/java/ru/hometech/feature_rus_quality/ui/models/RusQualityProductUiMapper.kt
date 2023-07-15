package ru.hometech.feature_rus_quality.ui.models

import ru.hometech.core_common.UiMapper
import ru.hometech.core_common.di.PerFeature
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
            price = price
        )
    }

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
            worth = worth,
            disadvantage = disadvantage,
            thumbnail = thumbnail,
            price = price
        )
    }
}
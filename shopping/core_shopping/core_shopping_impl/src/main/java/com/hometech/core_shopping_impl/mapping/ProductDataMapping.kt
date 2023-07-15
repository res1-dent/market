package com.hometech.core_shopping_impl.mapping

import com.example.core_shopping_api.models.EnumAmountType
import com.example.core_shopping_api.models.ProductDo
import com.example.core_shopping_api.models.ProductDto
import ru.hometech.core_common.DataMapper
import ru.hometech.core_common.di.PerFeature
import javax.inject.Inject

@PerFeature
class ProductDataMapping @Inject constructor() : DataMapper<ProductDo, ProductDto> {

    override fun toDo(dataModel: ProductDto): ProductDo = with(dataModel) {
        ProductDo(
            id = id,
            name = name,
            extra = extra,
            amount = amount,
            factAmount = factAmount,
            amountType = EnumAmountType.fromIntValue(amountType),
            searcherId = searcherId
        )
    }

    override fun toDto(domainModel: ProductDo): ProductDto = with(domainModel) {
        ProductDto(
            id = id,
            name = name,
            extra = extra,
            amount = amount,
            factAmount = factAmount,
            amountType = amountType.value,
            searcherId = searcherId
        )
    }
}
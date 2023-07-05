package ru.hometech.feature_shopping.models.mapping

import androidx.annotation.StringRes
import com.example.core_shopping_api.models.EnumAmountType
import com.example.core_shopping_api.models.ProductDo
import ru.hometech.core_common.UiMapper
import ru.hometech.feature_shopping.models.ProductUi
import ru.hometech.feature_shopping.models.SearchingStatus
import ru.hometech.marketgotogether.R
import javax.inject.Inject

class ProductUiMapping @Inject constructor(
    private val userId: String?,
) : UiMapper<ProductUi, ProductDo> {


    override fun mapToDomain(uiModel: ProductUi): ProductDo = with(uiModel) {
        return ProductDo(
            id = id,
            name = name,
            extra = extra,
            amount = needAmount,
            factAmount = factAmount,
            amountType = getAmountTypeFromRes(amountType),
            searcherId = getSearcherId(searchingStatus)
        )
    }

    override fun mapFromDomain(domainModel: ProductDo): ProductUi = with(domainModel) {
        ProductUi(
            id = id,
            name = name,
            extra = extra,
            needAmount = amount,
            factAmount = factAmount,
            amountType = getAmountTypeFromValue(amountType),
            searchingStatus = getSearchingStatus(this)
        )
    }


    private fun getSearchingStatus(productDo: ProductDo): SearchingStatus {
        return productDo.searcherId?.let {
            if (it == userId) SearchingStatus.CurrentUser
            else SearchingStatus.AnotherUser(it)
        } ?: SearchingStatus.None
    }

    private fun getSearcherId(searchingStatus: SearchingStatus): String? {
        return when (searchingStatus) {
            is SearchingStatus.AnotherUser -> searchingStatus.name
            SearchingStatus.CurrentUser -> userId
            SearchingStatus.None -> null
        }
    }

    @StringRes
    private fun getAmountTypeFromValue(amountType: EnumAmountType): Int =
        when (amountType) {
            EnumAmountType.KG -> R.string.kg
            EnumAmountType.LITERS -> R.string.liters
            EnumAmountType.UNIT -> R.string.unit
            EnumAmountType.UNKNOWN -> R.string.unknown
        }

    private fun getAmountTypeFromRes(@StringRes amountType: Int): EnumAmountType =
        when (amountType) {
            R.string.kg -> EnumAmountType.KG
            R.string.liters -> EnumAmountType.LITERS
            R.string.unit -> EnumAmountType.UNIT
            else -> EnumAmountType.UNKNOWN
        }

}
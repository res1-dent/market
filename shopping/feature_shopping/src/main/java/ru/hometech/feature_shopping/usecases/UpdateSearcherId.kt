package ru.hometech.feature_shopping.usecases

import com.example.core_shopping_api.repositories.SharedProductsListRepository
import com.hometech.core_auth_api.AuthHolder
import ru.hometech.core_common.di.PerFeature
import ru.hometech.feature_shopping.models.EnumChangeSearcherType
import javax.inject.Inject

@PerFeature
class UpdateSearcherId @Inject constructor(
    private val sharedProductsListRepository: SharedProductsListRepository,
    private val authHolder: AuthHolder
) {
    suspend operator fun invoke(productId: String, changeSearcherType: EnumChangeSearcherType) {
        val newSearcherId = when (changeSearcherType) {
            EnumChangeSearcherType.CURRENT_USER -> authHolder.getUserId()
            EnumChangeSearcherType.NONE -> null
        }
        sharedProductsListRepository.setNewSearcherId(productId, newSearcherId)
    }
}
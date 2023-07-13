package ru.hometech.feature_shopping.usecases

import kotlinx.coroutines.flow.Flow
import ru.hometech.core_common.coroutines.mapIterable
import ru.hometech.core_common.di.PerFeature
import ru.hometech.feature_shopping.models.EnumChangeSearcherType
import ru.hometech.feature_shopping.models.ProductUi
import ru.hometech.feature_shopping.models.mapping.ProductUiMapping
import javax.inject.Inject

@PerFeature
class IntentHandler @Inject constructor(
    private val addProductUseCase: AddProduct,
    private val deleteProductUseCase: DeleteProduct,
    private val updateSearcherIdUserCase: UpdateSearcherId,
    private val getAllProductsFlow: GetAllProductsFlow,
    private val productMapper: ProductUiMapping
) {
    suspend fun handleAddProduct(productUi: ProductUi) {
        addProductUseCase(productMapper.mapToDomain(productUi))
    }

    suspend fun handleUpdateSearcherId(
        productId: String,
        changeSearcherType: EnumChangeSearcherType
    ) {
        updateSearcherIdUserCase(productId, changeSearcherType)
    }

    suspend fun handleDeleteProduct(id: String) {
        deleteProductUseCase(id)
    }

    fun handleGetAllProductsFlow(): Flow<List<ProductUi>> =
        getAllProductsFlow().mapIterable { productMapper.mapToUi(it) }
}
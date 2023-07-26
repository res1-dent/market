package com.hometech.core_shopping.api.usecases

import com.hometech.core_shopping.api.models.ProductDo
import ru.hometech.core_common.usecases.ParameterlessUseCaseFlow
import ru.hometech.core_common.usecases.UseCase

object ShoppingUseCases {

    interface AddProduct: UseCase<ProductDo, Unit>

    interface DeleteProductById: UseCase<String, Unit>

    interface UpdateProduct: UseCase<ProductDo, Unit>

    interface GetAllProductsFlow: ParameterlessUseCaseFlow<List<ProductDo>>
}
package com.hometech.core_shopping.impl.di.modules

import com.hometech.core_shopping.api.usecases.ShoppingUseCases
import com.hometech.core_shopping.impl.usecases.AddProduct
import com.hometech.core_shopping.impl.usecases.DeleteProductById
import com.hometech.core_shopping.impl.usecases.GetAllProductsFlow
import com.hometech.core_shopping.impl.usecases.UpdateProduct
import dagger.Binds
import dagger.Module
import ru.hometech.core_common.di.PerFeature


@Module
internal interface DomainModule {

    @Binds
    @PerFeature
    fun bindsAddProductUseCase(impl: AddProduct): ShoppingUseCases.AddProduct

    @Binds
    @PerFeature
    fun bindsDeleteProductByIdUseCase(impl: DeleteProductById): ShoppingUseCases.DeleteProductById

    @Binds
    @PerFeature
    fun bindsUpdateProductUseCase(impl: UpdateProduct): ShoppingUseCases.UpdateProduct

    @Binds
    @PerFeature
    fun bindsGetAllProductsFlow(impl: GetAllProductsFlow): ShoppingUseCases.GetAllProductsFlow
}
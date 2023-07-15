package com.hometech.core_shopping_impl.di.modules

import com.example.core_shopping_api.usecases.ShoppingUseCases
import com.hometech.core_shopping_impl.usecases.AddProduct
import com.hometech.core_shopping_impl.usecases.DeleteProductById
import com.hometech.core_shopping_impl.usecases.GetAllProductsFlow
import com.hometech.core_shopping_impl.usecases.UpdateProduct
import dagger.Binds
import dagger.Module
import ru.hometech.core_common.di.PerFeature


@Module
interface DomainModule {

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
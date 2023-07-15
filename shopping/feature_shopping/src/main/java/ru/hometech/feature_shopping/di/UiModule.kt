package ru.hometech.feature_shopping.di

import com.hometech.core_auth_api.AuthHolder
import dagger.Module
import dagger.Provides
import ru.hometech.core_common.di.PerFeature
import ru.hometech.feature_shopping.models.mapping.ProductUiMapping

@Module
interface UiModule {

    companion object {
        @PerFeature
        @Provides
        fun provideProductMapper(authHolder: AuthHolder): ProductUiMapping {
            return ProductUiMapping(authHolder.getUserId())
        }
    }
}
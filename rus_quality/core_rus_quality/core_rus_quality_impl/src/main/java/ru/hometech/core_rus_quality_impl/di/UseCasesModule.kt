package ru.hometech.core_rus_quality_impl.di

import dagger.Binds
import dagger.Module
import ru.hometech.core_common.di.PerFeature
import ru.hometech.core_rus_quality_api.useCases.RusQualityUseCases
import ru.hometech.core_rus_quality_impl.useCases.GetRusQualityProductByBarcodeImpl

@Module
interface UseCasesModule {

    @Binds
    @PerFeature
    fun bindsGetRusQualityProductByBarcode(impl: GetRusQualityProductByBarcodeImpl): RusQualityUseCases.GetRusQualityProductByBarcode
}
package ru.hometech.core_rus_quality_api.di

import ru.hometech.core_rus_quality_api.useCases.RusQualityUseCases

interface CoreRusQualityDependencies {

    fun provideGetRusQualityProductByBarcode(): RusQualityUseCases.GetRusQualityProductByBarcode
}
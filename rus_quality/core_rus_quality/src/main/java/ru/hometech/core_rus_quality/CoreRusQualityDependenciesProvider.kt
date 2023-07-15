package ru.hometech.core_rus_quality

import ru.hometech.core_rus_quality_api.di.CoreRusQualityDependencies
import ru.hometech.core_rus_quality_impl.di.CoreRusQualityComponent

object CoreRusQualityDependenciesProvider {
    fun provide(): CoreRusQualityDependencies = CoreRusQualityComponent.getOrCreate()
}
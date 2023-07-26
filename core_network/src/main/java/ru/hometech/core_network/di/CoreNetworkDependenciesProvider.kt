package ru.hometech.core_network.di

import ru.hometech.core_network.api.di.CoreNetworkDependencies
import ru.hometech.core_network.impl.di.CoreNetworkComponent

object CoreNetworkDependenciesProvider {
    fun provide(): CoreNetworkDependencies = CoreNetworkComponent.NetworkComponentInjector.getOrCreate()
}
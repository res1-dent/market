package ru.hometech.core_network.di

import ru.hometech.core_network_api.di.CoreNetworkDependencies
import ru.hometech.core_network_impl.di.CoreNetworkComponent

object CoreNetworkDependenciesProvider {
    fun provide(): CoreNetworkDependencies = CoreNetworkComponent.NetworkComponentInjector.getOrCreate()
}
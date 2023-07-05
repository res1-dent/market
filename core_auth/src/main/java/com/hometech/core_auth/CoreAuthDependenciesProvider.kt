package com.hometech.core_auth

import com.hometech.core_auth_api.di.CoreAuthDependencies
import com.hometech.core_auth_impl.di.CoreAuthComponent

object CoreAuthDependenciesProvider {
    fun provide(): CoreAuthDependencies = CoreAuthComponent.CoreAuthInjector.getOrCreate()
}
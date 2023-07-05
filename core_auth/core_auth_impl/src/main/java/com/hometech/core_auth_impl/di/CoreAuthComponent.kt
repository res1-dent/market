package com.hometech.core_auth_impl.di

import com.hometech.core_auth_api.di.CoreAuthDependencies
import dagger.Component
import ru.hometech.core_common.di.PerFeature
import ru.hometech.core_common.di.injector.ParameterlessInjector

@Component(
    modules = [
        AuthModule::class
    ]
)
@PerFeature
interface CoreAuthComponent : CoreAuthDependencies {

    companion object CoreAuthInjector :
        ParameterlessInjector<CoreAuthComponent>(CoreAuthComponent::class) {
        override fun create(): CoreAuthComponent {
            return DaggerCoreAuthComponent.create()
        }
    }

}

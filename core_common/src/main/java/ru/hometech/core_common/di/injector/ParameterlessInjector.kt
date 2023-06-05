package ru.hometech.core_common.di.injector

abstract class ParameterlessInjector<Component : Any>: BaseInjector<Component>() {
    abstract fun create(): Component
    fun getOrCreate(): Component {
        if (!storage.containsKey(componentKey)) {
            storage.put(create(), componentKey)
        }
        return get()
    }
}
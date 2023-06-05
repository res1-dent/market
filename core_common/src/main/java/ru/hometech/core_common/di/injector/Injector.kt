package ru.hometech.core_common.di.injector

abstract class Injector<Params, Component : Any> : BaseInjector<Component>() {

    abstract fun create(params: Params): Component

    fun getOrCreate(params: Params): Component {
        if (!storage.containsKey(componentKey)) {
            storage.put(create(params), componentKey)
        }
        return get()
    }
}
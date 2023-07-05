package ru.hometech.core_common.di.injector

import kotlin.reflect.KClass

abstract class Injector<Params, Component : Any>(componentClass: KClass<Component>) : BaseInjector<Component>(componentClass) {

    abstract fun create(params: Params): Component

    fun getOrCreate(params: Params): Component {
        if (!storage.containsKey(componentClass)) {
            storage.put(create(params), componentClass)
        }
        return get()
    }

}
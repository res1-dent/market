package ru.hometech.core_common.di.injector

import kotlin.reflect.KClass

abstract class ParameterlessInjector<Component : Any>(componentClass: KClass<Component>) :
    BaseInjector<Component>(componentClass) {
    abstract fun create(): Component
    fun getOrCreate(): Component {
        if (!storage.containsKey(componentClass)) {
            storage.put(create(), componentClass)
        }
        return get()
    }
}
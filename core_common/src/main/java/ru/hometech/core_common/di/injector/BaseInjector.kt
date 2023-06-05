package ru.hometech.core_common.di.injector

import ru.hometech.core_common.di.ComponentsHolder

abstract class BaseInjector<Component : Any> {

    protected val storage = ComponentsHolder.getStorage()

    protected val componentKey: String = javaClass.simpleName
    fun get(): Component {
        return storage.getComponent(componentKey)
    }

    fun release() = storage.release(componentKey)
}
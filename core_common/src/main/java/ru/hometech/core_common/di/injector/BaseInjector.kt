package ru.hometech.core_common.di.injector

import ru.hometech.core_common.di.ComponentsHolder
import kotlin.reflect.KClass

abstract class BaseInjector<Component : Any>(val componentClass: KClass<Component>) {

    val storage = ComponentsHolder.getStorage()

    fun get(): Component = storage.getComponent(componentClass)

    fun release() = storage.release(componentClass)
}

inline fun <reified T : Any> BaseInjector<*>.findComponent(): T = storage.findComponent { it is T }


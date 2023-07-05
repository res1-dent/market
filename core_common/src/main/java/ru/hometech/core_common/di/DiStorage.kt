package ru.hometech.core_common.di

import kotlin.reflect.KClass

interface DiStorage {
    fun containsKey(key: KClass<*>): Boolean
    fun release(componentKey: KClass<*>)
    fun <Component : Any> put(component: Component, componentKey: KClass<*>)
    fun <Component : Any> getComponent(componentKey: KClass<*>): Component
    fun <Component : Any> findComponent(predicate: (Component) -> Boolean): Component
}

@Suppress("UNCHECKED_CAST")
internal class DiStorageImpl : DiStorage {

    private val map: MutableMap<KClass<*>, Any> = mutableMapOf()

    override fun containsKey(key: KClass<*>): Boolean = map.containsKey(key)

    @Synchronized
    override fun release(componentKey: KClass<*>) {
        map.remove(componentKey)
    }

    @Synchronized
    override fun <Component : Any> put(component: Component, componentKey: KClass<*>) {
        map[componentKey] = component
    }

    @Synchronized
    override fun <Component : Any> getComponent(componentKey: KClass<*>): Component =
        map[componentKey] as Component

    @Synchronized
    override fun <Component : Any> findComponent(predicate: (Component) -> Boolean): Component =
         map.values.first {
            predicate(it as Component)
        } as Component
}



package ru.hometech.core_common.di

interface DiStorage {
    fun containsKey (key: String): Boolean
    fun release(componentKey: String)
    fun <Component : Any> put(component: Component, componentKey: String)
    fun <Component : Any> getComponent(componentKey: String): Component
}

@Suppress("UNCHECKED_CAST")
internal class DiStorageImpl : DiStorage {

    private val map: MutableMap<String, Any> = mutableMapOf()

    override fun containsKey(key: String): Boolean = map.containsKey(key)

    @Synchronized
    override fun release(componentKey: String) {
        map.remove(componentKey)
    }

    @Synchronized
    override fun <Component : Any> put(component: Component, componentKey: String) {
        map[componentKey] = component
    }

    @Synchronized
    override fun <Component : Any> getComponent(componentKey: String): Component = map[componentKey] as Component

}


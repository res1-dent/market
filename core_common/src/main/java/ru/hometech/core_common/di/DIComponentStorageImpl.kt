package ru.hometech.core_common.di

@Suppress("UNCHECKED_CAST")
internal class ComponentStorage : DiStorage {

    private val map: MutableMap<String, Any> = mutableMapOf()

    @Synchronized
    override fun release(componentKey: String) {
        map.remove(componentKey)
    }

    @Synchronized
    override fun <T : Any> put(component: T, componentKey: String) {
        map[componentKey] = component
    }

    @Synchronized
    override fun <T : Any> getComponent(componentKey: String): T {
        return map[componentKey] as T
    }
}

interface DiStorage {
    fun release(componentKey: String)
    fun <T : Any> put(component: T, componentKey: String)
    fun <T : Any> getComponent(componentKey: String): T
}

object Components {

    private val storage = ComponentStorage()

    fun getStorage(): DiStorage = storage

}


abstract class Injector<Params, T : Any> {

    private val storage = Components.getStorage()

    private val componentKey = javaClass.simpleName

    abstract fun create(params: Params): T

    fun getOrCreate(params: Params): T {
        val component = create(params)
        storage.put(component, componentKey)
        return component
    }

    fun get(): T {
        return storage.getComponent(componentKey)
    }

    fun release() = storage.release(componentKey)
}
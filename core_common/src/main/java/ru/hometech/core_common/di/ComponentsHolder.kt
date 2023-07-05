package ru.hometech.core_common.di

internal object ComponentsHolder {

    private val storage = DiStorageImpl()

    fun getStorage(): DiStorage = storage
}
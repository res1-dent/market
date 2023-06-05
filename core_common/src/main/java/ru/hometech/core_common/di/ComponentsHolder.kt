package ru.hometech.core_common.di

object ComponentsHolder {

    private val storage = DiStorageImpl()

    fun getStorage(): DiStorage = storage
}
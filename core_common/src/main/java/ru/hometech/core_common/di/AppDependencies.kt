package ru.hometech.core_common.di

import android.content.Context
import ru.hometech.core_common.coroutines.DispatchersProvider

interface AppDependencies {
    fun getContext(): Context
    fun getDispatchersProvider(): DispatchersProvider
}
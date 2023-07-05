package ru.hometech.core_common

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavBackStackEntry

fun NavBackStackEntry.addObserver(onReleaseComponent: () -> Unit) {
    val observer = LifecycleEventObserver { s, event ->
        if (event == Lifecycle.Event.ON_DESTROY) {
            onReleaseComponent()
        }
    }
    getLifecycle().addObserver(observer)
}
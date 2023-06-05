package ru.hometech.core_common.di

import androidx.lifecycle.ViewModel
import javax.inject.Scope

interface BaseComponent {
    fun getViewModel(): ViewModel
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerFeature

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope

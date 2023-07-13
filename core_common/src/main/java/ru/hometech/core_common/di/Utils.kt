package ru.hometech.core_common.di

import javax.inject.Scope

interface FeatureComponent {
    fun getViewModelFactory(): MultiViewModelFactory
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerFeature

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope

package com.hometech.core_auth_impl.di

import com.hometech.core_auth_api.AuthHolder
import com.hometech.core_auth_api.FirebaseAnonymousAuth
import com.hometech.core_auth_impl.FirebaseAnonymousAuthImpl
import dagger.Binds
import dagger.Module
import ru.hometech.core_common.di.PerFeature

@Module
interface AuthModule {

    @PerFeature
    @Binds
    fun provideAuthHolder(impl: FirebaseAnonymousAuthImpl): AuthHolder

    @PerFeature
    @Binds
    fun provideFirebaseAnonymousAuth(impl: FirebaseAnonymousAuthImpl): FirebaseAnonymousAuth

}
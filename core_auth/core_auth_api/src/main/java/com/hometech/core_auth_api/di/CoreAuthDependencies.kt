package com.hometech.core_auth_api.di

import com.hometech.core_auth_api.AuthHolder
import com.hometech.core_auth_api.FirebaseAnonymousAuth

interface CoreAuthDependencies {
    fun getAuthHolder(): AuthHolder
    fun getAuth(): FirebaseAnonymousAuth
}
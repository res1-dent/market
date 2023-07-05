package com.hometech.core_auth_impl

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.hometech.core_auth_api.AuthHolder
import com.hometech.core_auth_api.FirebaseAnonymousAuth
import com.hometech.core_auth_api.exceptions.NotAuthorizedException
import ru.hometech.core_common.di.PerFeature
import javax.inject.Inject

@PerFeature
class FirebaseAnonymousAuthImpl @Inject constructor() : AuthHolder, FirebaseAnonymousAuth {

    init {
        Log.e("!!!", "init $this")
    }

    private val firebaseAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

    private var userId: String? = null

    override fun signIn() {
        firebaseAuth.signInAnonymously()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    userId = task.result?.user?.uid
                }
            }
    }

    override fun getUserId(): String {
        return userId ?: throw NotAuthorizedException()
    }
}
package ru.hometech.markettogether

import android.app.Application
import com.hometech.core_auth_api.FirebaseAnonymousAuth
import ru.hometech.markettogether.di.AppComponent
import javax.inject.Inject

class App : Application() {

    @Inject
    lateinit var auth: FirebaseAnonymousAuth

    override fun onCreate() {
        super.onCreate()
        AppComponent.getOrCreate(this).inject(this)
        auth.signIn()
    }
}
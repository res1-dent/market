package ru.hometech.markettogether

import android.app.Application
import ru.hometech.markettogether.di.MainComponent

class App : Application() {


    override fun onCreate() {
        super.onCreate()
        MainComponent.getOrCreate(this)
    }
}
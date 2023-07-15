package ru.hometech.core_network_api.di

import com.google.firebase.firestore.FirebaseFirestore
import ru.hometech.core_network_api.repositories.RusQualityRepository

interface CoreNetworkDependencies {
    fun provideFireStore(): FirebaseFirestore

    fun provideRosQualityRepository(): RusQualityRepository
}
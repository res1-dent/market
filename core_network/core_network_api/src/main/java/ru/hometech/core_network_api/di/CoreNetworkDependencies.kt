package ru.hometech.core_network_api.di

import com.google.firebase.firestore.FirebaseFirestore

interface CoreNetworkDependencies {
    fun provideFireStore(): FirebaseFirestore
}
package ru.hometech.core_network_impl.di.modules

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import ru.hometech.core_common.di.PerFeature

@Module
class DataModule {

    @Provides
    @PerFeature
    fun provideFirebaseFirestore(): FirebaseFirestore = Firebase.firestore
}
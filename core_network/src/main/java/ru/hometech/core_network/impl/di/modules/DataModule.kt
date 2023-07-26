package ru.hometech.core_network.impl.di.modules

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.hometech.core_common.di.PerFeature
import ru.hometech.core_network.impl.repositories.RusQualityRepositoryImpl

@Module
internal interface DataModule {

    companion object {
        @Provides
        @PerFeature
        fun provideFirebaseFirestore(): FirebaseFirestore = Firebase.firestore
    }


    @Binds
    @PerFeature
    fun bindsRosQualityRepository(impl: RusQualityRepositoryImpl): ru.hometech.core_network.api.repositories.RusQualityRepository
}
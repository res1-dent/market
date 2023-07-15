package ru.hometech.core_network_impl.di.modules

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.hometech.core_common.di.PerFeature
import ru.hometech.core_network_api.repositories.RusQualityRepository
import ru.hometech.core_network_impl.repositories.RusQualityRepositoryImpl

@Module
interface DataModule {

    companion object {
        @Provides
        @PerFeature
        fun provideFirebaseFirestore(): FirebaseFirestore = Firebase.firestore
    }


    @Binds
    @PerFeature
    fun bindsRosQualityRepository(impl: RusQualityRepositoryImpl): RusQualityRepository
}
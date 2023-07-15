package ru.hometech.core_network_impl.di.modules

import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.hometech.core_common.di.PerFeature
import ru.hometech.core_network_impl.Constants
import ru.hometech.core_network_impl.rest.RusQualityApi
import javax.inject.Qualifier

@Module
class NetworkModule {

/**-------------------------------Interceptors----------------------------------------------------*/
    @Provides
    @PerFeature
    @LoggingInterceptor
    fun provideLoggingInterceptor(): Interceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

/**--------------------------------Retrofit and API-----------------------------------------------*/
    @Provides
    @PerFeature
    fun provideOkHttpClient(@LoggingInterceptor loggingInterceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

    @Provides
    @PerFeature
    @RusQualityRetrofit
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.RusQuality.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @PerFeature
    fun provideRusQualityApi(@RusQualityRetrofit retrofit: Retrofit): RusQualityApi {
        return retrofit.create(RusQualityApi::class.java)
    }

/**------------------------------Qualifiers-------------------------------------------------------*/
    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class LoggingInterceptor

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class RusQualityRetrofit

}
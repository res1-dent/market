package ru.hometech.core_network_impl.di.modules

import com.google.gson.Gson
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
import ru.hometech.core_network_impl.rest.interceptors.RusQualityInterceptor
import ru.hometech.core_network_impl.rest.interceptors.RusQualityTypeInterceptor
import javax.inject.Qualifier

@Module
class NetworkModule {

    @Provides
    @PerFeature
    fun provideGson(): Gson = Gson()

/**-------------------------------Interceptors----------------------------------------------------*/
    @Provides
    @PerFeature
    @LoggingInterceptor
    fun provideLoggingInterceptor(): Interceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Provides
    @PerFeature
    @RusQualityTypeInterceptor
    fun provideRusQualityInterceptor(gson: Gson): Interceptor {
        return RusQualityInterceptor(gson)
    }

/**--------------------------------Retrofit and API-----------------------------------------------*/
    @Provides
    @PerFeature
    fun provideOkHttpClient(
        @LoggingInterceptor loggingInterceptor: Interceptor,
        @RusQualityTypeInterceptor rusQualityInterceptor: Interceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addNetworkInterceptor(rusQualityInterceptor)
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
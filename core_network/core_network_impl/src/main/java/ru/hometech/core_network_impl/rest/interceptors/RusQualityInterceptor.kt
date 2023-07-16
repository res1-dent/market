package ru.hometech.core_network_impl.rest.interceptors

import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.Response
import ru.hometech.core_network_api.exceptions.ErrorFetchingRusQualityProduct
import ru.hometech.core_network_impl.rest.models.RusQualityErrorResponse
import javax.inject.Inject
import javax.inject.Qualifier

class RusQualityInterceptor @Inject constructor(
    private val gson: Gson
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        if (response.code == 406) {
           gson.fromJson(response.body?.string(), RusQualityErrorResponse::class.java)?.let {
               throw ErrorFetchingRusQualityProduct(it.messages.firstOrNull()?.message ?: "NoRusQualityProduct")
           }
        }
        return response
    }
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class RusQualityTypeInterceptor
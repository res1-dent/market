package ru.hometech.core_network.impl.repositories

import android.util.Log
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import ru.hometech.core_common.coroutines.DispatchersProvider
import ru.hometech.core_network.api.exceptions.RusQualityProductNotFound
import ru.hometech.core_network.api.models.RusQualityProductDTOI
import ru.hometech.core_network.impl.rest.RusQualityApi
import java.net.URLDecoder
import javax.inject.Inject

internal class RusQualityRepositoryImpl @Inject constructor(
    private val rusQualityApi: RusQualityApi,
    private val dispatchersProvider: DispatchersProvider
) : ru.hometech.core_network.api.repositories.RusQualityRepository {

    override suspend fun getProductByBarcode(barcode: String): RusQualityProductDTOI =
        withContext(dispatchersProvider.io) {
            test()
            rusQualityApi.searchBarcode(barcode).also {
                it.rusQualityProductResponseDTOI.id ?: throw RusQualityProductNotFound()
            }
        }


    private suspend fun test() {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://www.perekrestok.ru/")
            .get()
            .build()
        try {
            client.newCall(request).execute().use { response ->

                val headers = response.headers
                val cookies = headers.values("Set-Cookie")
                cookies.forEach { cookie ->
                    val splits = cookie.split(";")
                    splits.forEach {
                            cookieValue ->
                        if (cookieValue.contains("accessToken")) {
                            val decodedCookie = URLDecoder.decode(cookieValue, "UTF-8").removePrefix("session=")
                            Log.e("!!!","decode = $decodedCookie")
                            val jsonCookie = JSONObject(decodedCookie)
                            val accessToken = jsonCookie.getString("accessToken")
                            Log.e("!!!", "access = $accessToken")
                            Log.e("!!!", "jsonCookie = $jsonCookie")
                            // Ваши действия с accessToken
                        }
                    }
                }

            }
        } catch (e: Throwable) {
            Log.e("!!!", "${e.message}")
            // извлеките сессионную cookie отсюда, именно здесь вы находите свой токен.
        }
    }
}
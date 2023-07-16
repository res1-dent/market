package ru.hometech.core_network_api.exceptions

import java.io.IOException

/**
 * Ошибка кадется, когда у роскачества нет в базе товара
 */
class ErrorFetchingRusQualityProduct(override val message: String): IOException(message)
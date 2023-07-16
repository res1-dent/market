package ru.hometech.core_network_impl.rest.models

import com.google.gson.annotations.SerializedName


data class RusQualityErrorResponse(
        @SerializedName("message")
        val messages: List<RusQualityErrorMessage>
)
data class RusQualityErrorMessage(
        @SerializedName("message_id")
        val id: String,
        val type: String,
        val message: String
)

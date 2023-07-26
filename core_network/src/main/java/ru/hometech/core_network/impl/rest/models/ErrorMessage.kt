package ru.hometech.core_network.impl.rest.models

import com.google.gson.annotations.SerializedName

internal data class RusQualityErrorResponse(
        @SerializedName("message")
        val messages: List<RusQualityErrorMessage>
)
internal data class RusQualityErrorMessage(
        @SerializedName("message_id")
        val id: String,
        val type: String,
        val message: String
)

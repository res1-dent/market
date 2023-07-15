package ru.hometech.core_network_api.models

import com.google.gson.annotations.SerializedName


data class RusQualityProductDTOI(
        @SerializedName("response")
        val rusQualityProductResponseDTOI: RusQualityProductResponseDTOI,
)
data class RusQualityProductResponseDTOI(
        val id: Int,
        val title: String,
        @SerializedName("total_rating")
        val totalRating: Double,
        @SerializedName("product_link")
        val productLink: String,
        @SerializedName("category_name")
        val categoryName: String,
        val manufacturer: String,
        @SerializedName("research")
        val researchDTOI: ResearchDTOI,
        val worth: List<String>,
        val disadvantage: List<String>?,
        val thumbnail: String,
        val price: String
)

data class ResearchDTOI(
        val id: Int,
        val title: String,
        val product_group: String,
        val image: String,
        val date: String
)

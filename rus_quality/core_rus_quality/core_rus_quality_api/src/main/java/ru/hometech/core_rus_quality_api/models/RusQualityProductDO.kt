package ru.hometech.core_rus_quality_api.models

data class RusQualityProductDO(
    val id: Int?,
    val title: String,
    val totalRating: Double,
    val productLink: String,
    val categoryName: String,
    val manufacturer: String,
    val research: ResearchDO,
    val worth: List<String>?,
    val disadvantage: List<String>?,
    val thumbnail: String,
    val price: String,
    val productInfo: List<ProductInfoDo>
)
data class ResearchDO(
    val id: Int,
    val title: String,
    val productGroup: String,
    val image: String,
    val date: String
)

data class ProductInfoDo(
    val name: String,
    val value: String
)
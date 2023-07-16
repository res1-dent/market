package ru.hometech.feature_rus_quality.ui.models


data class RusQualityProductUi(
    val id: Int?,
    val title: String,
    val totalRating: Double,
    val productLink: String,
    val categoryName: String,
    val manufacturer: String,
    val research: ResearchUi,
    val worth: List<String>,
    val disadvantage: List<String>,
    val thumbnail: String,
    val price: String,
    val productInfo: List<ProductInfoUi>
)

data class ResearchUi(
    val id: Int,
    val title: String,
    val productGroup: String,
    val image: String,
    val date: String
)

data class ProductInfoUi(
    val name: String,
    val value: String
)

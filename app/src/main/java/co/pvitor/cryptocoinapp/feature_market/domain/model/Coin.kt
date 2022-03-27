package co.pvitor.cryptocoinapp.feature_market.domain.model

import com.google.gson.annotations.SerializedName

data class Coin(
    val id: String,
    val symbol: String,
    val name: String,
    val currentPrice: Double
)
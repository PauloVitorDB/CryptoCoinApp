package co.pvitor.cryptocoinapp.feature_market.data.data_source.remote.dto

import co.pvitor.cryptocoinapp.feature_market.domain.model.Coin
import com.google.gson.annotations.SerializedName

data class CoinDto(
    val id: String,
    val symbol: String,
    val name: String,
    @SerializedName("current_price")
    val currentPrice: Double
)

fun CoinDto.toModel() = Coin(
    id = id,
    symbol = symbol,
    name = name,
    currentPrice = currentPrice
)
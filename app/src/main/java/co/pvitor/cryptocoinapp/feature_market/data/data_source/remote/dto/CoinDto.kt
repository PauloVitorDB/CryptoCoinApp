package co.pvitor.cryptocoinapp.feature_market.data.data_source.remote.dto

import co.pvitor.cryptocoinapp.feature_market.domain.model.Coin
import com.google.gson.annotations.SerializedName

data class CoinDto(
    val ath: Double,
    val ath_change_percentage: Double,
    val ath_date: String,
    val atl: Double,
    val atl_change_percentage: Double,
    val atl_date: String,
    val circulating_supply: Double,
    @SerializedName("current_price")
    val currentPrice: Double,
    val fully_diluted_valuation: Long,
    val high_24h: Double,
    val id: String,
    val image: String,
    val last_updated: String,
    val low_24h: Double,
    @SerializedName("market_cap")
    val marketCap: Double,
    val market_cap_change_24h: Double,
    val market_cap_change_percentage_24h: Double,
    @SerializedName("market_cap_rank")
    val marketCapRank: Int,
    val max_supply: Double,
    val name: String,
    val price_change_24h: Double,
    val price_change_percentage_24h: Double,
    val roi: Any,
    val symbol: String,
    val total_supply: Double,
    val total_volume: Double
)

fun CoinDto.toModel() = Coin(
    id = id,
    symbol = symbol,
    name = name,
    currentPrice = currentPrice,
    image = image,
    marketCapRank = marketCapRank,
    marketCap = marketCap
)
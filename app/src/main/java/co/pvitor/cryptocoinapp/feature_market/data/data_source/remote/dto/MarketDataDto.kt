package co.pvitor.cryptocoinapp.feature_market.data.data_source.remote.dto

import co.pvitor.cryptocoinapp.feature_market.domain.model.CoinMarketData
import co.pvitor.cryptocoinapp.util.findClassPropertyValue
import co.pvitor.cryptocoinapp.util.formatCurrency
import com.google.gson.annotations.SerializedName

data class MarketDataDto(
    @SerializedName("market_cap_rank")
    val marketCapRank: Int,
    @SerializedName("current_price")
    val currentPrice: SupportedCurrency,
    @SerializedName("market_cap")
    val marketCap: SupportedCurrency,
    @SerializedName("high_24h")
    val high24h: SupportedCurrency,
    @SerializedName("fully_diluted_valuation")
    val fullyDilutedValuation: SupportedCurrency,
    @SerializedName("low_24h")
    val low24h: SupportedCurrency,
    @SerializedName("total_supply")
    val totalSupply: Double,
    @SerializedName("max_supply")
    val maxSupply: Double,
    @SerializedName("circulating_supply")
    val circulatingSupply: Double,
    @SerializedName("total_volume")
    val totalVolume: SupportedCurrency
//    val ath: Ath,
//    val ath_change_percentage: AthChangePercentage,
//    val ath_date: AthDate,
//    val atl: Atl,
//    val atl_change_percentage: AtlChangePercentage,
//    val atl_date: AtlDate,
//    val circulating_supply: Double,
//    val current_price: CurrentPrice,
//    val fdv_to_tvl_ratio: Any,
//    val fully_diluted_valuation: FullyDilutedValuation,
//    val high_24h: High24h,
//    val last_updated: String,
//    val low_24h: Low24h,
//    val market_cap: MarketCap,
//    val market_cap_change_24h: Long,
//    val market_cap_change_24h_in_currency: MarketCapChange24hInCurrency,
//    val market_cap_change_percentage_24h: Double,
//    val market_cap_change_percentage_24h_in_currency: MarketCapChangePercentage24hInCurrency,
//    val market_cap_rank: Int,
//    val max_supply: Double,
//    val mcap_to_tvl_ratio: Any,
//    val price_change_24h: Double,
//    val price_change_24h_in_currency: PriceChange24hInCurrency,
//    val price_change_percentage_14d: Double,
//    val price_change_percentage_14d_in_currency: PriceChangePercentage14dInCurrency,
//    val price_change_percentage_1h_in_currency: PriceChangePercentage1hInCurrency,
//    val price_change_percentage_1y: Double,
//    val price_change_percentage_1y_in_currency: PriceChangePercentage1yInCurrency,
//    val price_change_percentage_200d: Double,
//    val price_change_percentage_200d_in_currency: PriceChangePercentage200dInCurrency,
//    val price_change_percentage_24h: Double,
//    val price_change_percentage_24h_in_currency: PriceChangePercentage24hInCurrency,
//    val price_change_percentage_30d: Double,
//    val price_change_percentage_30d_in_currency: PriceChangePercentage30dInCurrency,
//    val price_change_percentage_60d: Double,
//    val price_change_percentage_60d_in_currency: PriceChangePercentage60dInCurrency,
//    val price_change_percentage_7d: Double,
//    val price_change_percentage_7d_in_currency: PriceChangePercentage7dInCurrency,
//    val roi: Any,
//    val total_supply: Double,
//    val total_value_locked: Any,
)

fun MarketDataDto.toModel(coin: String) : CoinMarketData {
    val marketData = CoinMarketData(
        currentPrice = currentPrice.findClassPropertyValue<Double>(coin).formatCurrency(coin),
        marketCapRank = marketCapRank,
        marketCap = marketCap.findClassPropertyValue<Double>(coin).formatCurrency(coin),
        high24h = high24h.findClassPropertyValue<Double>(coin).formatCurrency(coin),
        fullyDilutedValuation = fullyDilutedValuation.findClassPropertyValue<Double>(coin).formatCurrency(coin),
        low24h = low24h.findClassPropertyValue<Double>(coin).formatCurrency(coin),
        totalSupply = totalSupply.formatCurrency(coin),
        maxSupply = maxSupply.formatCurrency(coin),
        circulatingSupply = circulatingSupply.formatCurrency(coin),
        totalVolume = totalVolume.findClassPropertyValue<Double>(coin).formatCurrency(coin)
    )

    return marketData
}


package co.pvitor.cryptocoinapp.feature_market.data.data_source.remote.dto

import com.google.gson.annotations.SerializedName

data class DetailedCoinPriceDto(
    @SerializedName("market_data")
    val marketData: MarketDataDto
)
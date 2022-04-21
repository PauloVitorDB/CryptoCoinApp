package co.pvitor.cryptocoinapp.feature_market.domain.repository

import co.pvitor.cryptocoinapp.feature_market.data.data_source.remote.dto.CoinDto
import co.pvitor.cryptocoinapp.feature_market.data.data_source.remote.dto.DetailedCoinPriceDto

interface CoinRepository {

    suspend fun getMarketCoins(
        currency: String? = "usd",
        page: Int?,
        per_page: Int?
    ) : List<CoinDto>

    suspend fun getDetailedCoinPrice(id: String) : DetailedCoinPriceDto
}
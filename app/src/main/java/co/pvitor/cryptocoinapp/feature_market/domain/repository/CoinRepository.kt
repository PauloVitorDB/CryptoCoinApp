package co.pvitor.cryptocoinapp.feature_market.domain.repository

import co.pvitor.cryptocoinapp.feature_market.data.data_source.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getMarketCoins() : List<CoinDto>

    suspend fun getCoin(id: String) : CoinDto

}
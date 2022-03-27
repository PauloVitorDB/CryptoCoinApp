package co.pvitor.cryptocoinapp.feature_market.data.repository

import co.pvitor.cryptocoinapp.feature_market.data.data_source.remote.CoinGeckoApi
import co.pvitor.cryptocoinapp.feature_market.data.data_source.remote.dto.CoinDto
import co.pvitor.cryptocoinapp.feature_market.domain.repository.CoinRepository

class CoinRepositoryImpl(
    private val dataSource: CoinGeckoApi
) : CoinRepository {

    override suspend fun getMarketCoins(): List<CoinDto> {
        return dataSource.getMarketCoins()
    }

    override suspend fun getCoin(id: String): CoinDto {
        return dataSource.getCoinById(id)
    }

}
package co.pvitor.cryptocoinapp.feature_market.data.repository

import co.pvitor.cryptocoinapp.feature_market.data.data_source.remote.CoinGeckoApi
import co.pvitor.cryptocoinapp.feature_market.data.data_source.remote.dto.CoinDto
import co.pvitor.cryptocoinapp.feature_market.data.data_source.remote.dto.DetailedCoinPriceDto
import co.pvitor.cryptocoinapp.feature_market.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val dataSource: CoinGeckoApi
) : CoinRepository {

    override suspend fun getMarketCoins(currency: String?, page: Int?, per_page: Int?) : List<CoinDto> {
        return dataSource.getMarketCoins(
            currency,
            page,
            per_page
        )
    }

    override suspend fun getDetailedCoinPrice(id: String): DetailedCoinPriceDto {
        return dataSource.getDetailedCoinPriceById(
            id = id
        )
    }

}
package co.pvitor.cryptocoinapp.feature_market.domain.use_case

import co.pvitor.cryptocoinapp.feature_market.domain.use_case.detailed_coin.DetailedCoinPrice
import co.pvitor.cryptocoinapp.feature_market.domain.use_case.list_coins.ListCoins
import javax.inject.Inject

data class MarketUseCases @Inject constructor(
    val listCoins: ListCoins,
    val detailedCoinPrice: DetailedCoinPrice
)
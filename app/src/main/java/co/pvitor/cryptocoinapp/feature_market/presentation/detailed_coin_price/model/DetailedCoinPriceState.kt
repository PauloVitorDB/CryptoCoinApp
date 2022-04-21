package co.pvitor.cryptocoinapp.feature_market.presentation.detailed_coin_price.model

import co.pvitor.cryptocoinapp.feature_market.domain.model.CoinMarketData

data class DetailedCoinPriceState(
    val detailedCoinPrice: CoinMarketData? = null
)
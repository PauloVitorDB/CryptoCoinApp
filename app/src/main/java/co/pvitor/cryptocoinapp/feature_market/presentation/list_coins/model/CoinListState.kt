package co.pvitor.cryptocoinapp.feature_market.presentation.list_coins.model

import co.pvitor.cryptocoinapp.feature_market.domain.model.Coin

data class CoinListState(
    val coinList: MutableList<Coin>? = mutableListOf(),
    var isLoading: Boolean? = false,
    val error: String? = null
)

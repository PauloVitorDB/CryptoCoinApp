package co.pvitor.cryptocoinapp.feature_market.presentation.market.adapter

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import co.pvitor.cryptocoinapp.R
import co.pvitor.cryptocoinapp.feature_market.presentation.list_coins.ListCoinsFragment
import co.pvitor.cryptocoinapp.feature_market.presentation.list_exchanges.ListExchangesFragment

sealed class MarketFragments<out T: Class<V>, V>(
    val fragment: T,
    @StringRes val title: Int? = null
) {

    object ListCoins : MarketFragments<Class<ListCoinsFragment>, ListCoinsFragment>(
        fragment = ListCoinsFragment::class.java,
        R.string.label_cryptocurrency
    )

    object ListExchanges : MarketFragments<Class<ListExchangesFragment>, ListExchangesFragment>(
        fragment = ListExchangesFragment::class.java,
        R.string.label_exchanges
    )

}

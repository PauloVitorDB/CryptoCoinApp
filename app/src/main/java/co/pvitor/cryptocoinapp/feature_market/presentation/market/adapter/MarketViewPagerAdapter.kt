package co.pvitor.cryptocoinapp.feature_market.presentation.market.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import co.pvitor.cryptocoinapp.R
import co.pvitor.cryptocoinapp.feature_market.presentation.list_coins.ListCoinsFragment
import java.lang.IllegalArgumentException

class MarketViewPagerAdapter(
    fragment: Fragment
): FragmentStateAdapter(fragment) {

     val fragmentList = arrayListOf(
        MarketFragments.ListCoins,
        MarketFragments.ListExchanges
    )

    override fun createFragment(position: Int) : Fragment {
        return when(fragmentList[position]) {
            is MarketFragments.ListCoins -> MarketFragments.ListCoins.fragment.newInstance()
            is MarketFragments.ListExchanges -> MarketFragments.ListExchanges.fragment.newInstance()
        }
    }

    override fun getItemCount(): Int = fragmentList.size

}


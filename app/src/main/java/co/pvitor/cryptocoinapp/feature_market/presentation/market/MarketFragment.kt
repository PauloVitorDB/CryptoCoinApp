package co.pvitor.cryptocoinapp.feature_market.presentation.market

import androidx.viewpager2.widget.ViewPager2
import co.pvitor.cryptocoinapp.R
import co.pvitor.cryptocoinapp.common.ui.BaseFragment
import co.pvitor.cryptocoinapp.databinding.FragmentMarketBinding
import co.pvitor.cryptocoinapp.feature_market.presentation.market.adapter.MarketViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MarketFragment: BaseFragment<FragmentMarketBinding>(
    R.layout.fragment_market,
    FragmentMarketBinding::bind
) {

    override fun setupOnViewCreated() {

        val tabLayout: TabLayout = binding.tabLayoutMarket

        val viewPager2: ViewPager2 = binding.viewPagerContent
        val viewPagerAdapter = MarketViewPagerAdapter(this)
        viewPager2.adapter = viewPagerAdapter

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->

            val tabTextRes = viewPagerAdapter.fragmentList[position].title
            tabTextRes?.let {
                tab.text = getText(it)
            }

        }.attach()

    }

}
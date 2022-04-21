package co.pvitor.cryptocoinapp.feature_market.presentation.detailed_coin_price

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import co.pvitor.cryptocoinapp.R
import co.pvitor.cryptocoinapp.common.ui.BaseFragment
import co.pvitor.cryptocoinapp.databinding.FragmentDetailedCoinPriceBinding
import co.pvitor.cryptocoinapp.feature_market.presentation.detailed_coin_price.model.DetailedCoinPriceState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailedCoinPriceFragment : BaseFragment<FragmentDetailedCoinPriceBinding>(
    R.layout.fragment_detailed_coin_price,
    FragmentDetailedCoinPriceBinding::bind
) {

    private val viewModel : DetailedCoinPriceViewModel by lazy {
        ViewModelProvider(this).get(DetailedCoinPriceViewModel::class.java)
    }

    override fun setupOnViewCreated() {

        viewModel.state.observe(this, Observer<DetailedCoinPriceState> { state ->

            state.detailedCoinPrice?.let {
                binding.textViewCoinPrice.text = it.currentPrice
                binding.textViewCoinMarket24High.text = it.high24h
                binding.textViewCoinMarket24Low.text = it.low24h
                binding.textViewCoinMarketAvailableSupply.text = it.circulatingSupply
                binding.textViewCoinMarketMaxSupply.text = it.maxSupply
                binding.textViewCoinMarketTotalSupply.text = it.totalSupply
                binding.textViewCoinMarketCap.text = it.marketCap
                binding.textViewCoinMarketRank.text = it.marketCapRank.toString()
                binding.textViewCoinMarketValuation.text = it.fullyDilutedValuation
                binding.textViewCoinMarketVolume.text = it.totalVolume
            }

        })

    }
}
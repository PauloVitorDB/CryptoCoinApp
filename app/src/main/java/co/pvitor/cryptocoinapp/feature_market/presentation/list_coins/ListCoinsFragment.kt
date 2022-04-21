package co.pvitor.cryptocoinapp.feature_market.presentation.list_coins

import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.pvitor.cryptocoinapp.R
import co.pvitor.cryptocoinapp.common.ui.BaseFragment
import co.pvitor.cryptocoinapp.common.ui.BaseRecyclerViewPagination
import co.pvitor.cryptocoinapp.databinding.FragmentListCoinsBinding
import co.pvitor.cryptocoinapp.feature_market.domain.model.Coin
import co.pvitor.cryptocoinapp.feature_market.presentation.list_coins.adapter.ListCoinAdapter
import co.pvitor.cryptocoinapp.feature_market.presentation.list_coins.model.CoinListState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListCoinsFragment(): BaseFragment<FragmentListCoinsBinding>(
    R.layout.fragment_list_coins,
    FragmentListCoinsBinding::bind
) {

    private val viewModel: ListCoinsViewModel by lazy {
        ViewModelProvider(this).get(ListCoinsViewModel::class.java)
    }

    private val coinListLayoutManager by lazy {
        LinearLayoutManager(context, RecyclerView.VERTICAL, false)
    }

    private lateinit var coinListAdapter : ListCoinAdapter

    override fun setupOnViewCreated() {

        val rvMarketCoins: RecyclerView = binding.rvMarketCoins
        rvMarketCoins.layoutManager = coinListLayoutManager

        coinListAdapter = ListCoinAdapter()
        coinListAdapter.differ.addListListener(listListener)
        rvMarketCoins.adapter = coinListAdapter

        rvMarketCoins.addOnScrollListener(rvListCoinsScrollListener)

        viewModel.state.observe(this, Observer<CoinListState> { state: CoinListState ->

            state.coinList?.let {
                populateCoinList(it)
            }

            state.isLoading?.let {
                showProgressBar(true)
            }

        })

    }

    private val rvListCoinsScrollListener = object : BaseRecyclerViewPagination(coinListLayoutManager) {
        override fun onLoadItems(currentPage: Int, totalListItemsBound: Int) {
            viewModel.getCoinList(currentPage)
        }
    }

    private fun populateCoinList(coinList: List<Coin>) {
        coinListAdapter.differ.submitList(coinList.toMutableList())
    }

    private val listListener = object : AsyncListDiffer.ListListener<Coin> {
        override fun onCurrentListChanged(
            previousList: MutableList<Coin>,
            currentList: MutableList<Coin>
        ) {
            if((previousList.size < currentList.size) && currentList.size > 0) {
                showProgressBar(false)
            }
        }
    }

    private fun showProgressBar(visible: Boolean) {
        binding.progressBarCoinList.visibility = if(visible) View.VISIBLE else View.INVISIBLE
    }

}
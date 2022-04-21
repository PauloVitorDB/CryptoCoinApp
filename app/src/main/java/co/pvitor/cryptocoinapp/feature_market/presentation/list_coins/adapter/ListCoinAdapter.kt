package co.pvitor.cryptocoinapp.feature_market.presentation.list_coins.adapter

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import co.pvitor.cryptocoinapp.common.ui.BaseRecyclerViewAdapter
import co.pvitor.cryptocoinapp.databinding.CoinItemBinding
import co.pvitor.cryptocoinapp.feature_market.domain.model.Coin
import com.squareup.picasso.Picasso

class ListCoinAdapter : BaseRecyclerViewAdapter<CoinItemBinding, Coin>(
    CoinItemBinding::inflate
) {

    override val differCallback = object : DiffUtil.ItemCallback<Coin>() {
        override fun areItemsTheSame(oldItem: Coin, newItem: Coin): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Coin, newItem: Coin): Boolean {
            return oldItem == newItem
        }
    }

    override fun onBindData(modelItem: Coin, binding: CoinItemBinding) {
        with(modelItem) {

            binding.textViewRank.text = marketCapRank.toString()
            binding.textViewPrice.text = currentPrice.toString()
            binding.textViewMarket.text = marketCap.toString()

            binding.textViewCoin.text = symbol
            Picasso.with(binding.root.context).load(image).into(binding.imageViewCoin)

        }
    }

}
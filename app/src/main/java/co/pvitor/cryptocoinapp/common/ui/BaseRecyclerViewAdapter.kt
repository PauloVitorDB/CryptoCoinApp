package co.pvitor.cryptocoinapp.common.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import co.pvitor.cryptocoinapp.databinding.CoinItemBinding
import co.pvitor.cryptocoinapp.util.ListDifferCallback

abstract class BaseRecyclerViewAdapter<T: ViewBinding, V>(
    private val inflate : (LayoutInflater, ViewGroup, Boolean) -> T
) : RecyclerView.Adapter<BaseRecyclerViewAdapter<T, V>.BaseRecyclerViewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : BaseRecyclerViewViewHolder {
        val binding = inflate.invoke(LayoutInflater.from(parent.context), parent, false)
        return BaseRecyclerViewViewHolder(binding)
    }

    inner class BaseRecyclerViewViewHolder(private val binding: T) : RecyclerView.ViewHolder(binding.root) {
        fun bind(modelItem: V) {
            onBindData(modelItem, binding)
        }
    }

//     -- Using generic to check types in list by position  --
//     fun dispatchListUpdates(itemList: List<V>) {
//        val listDifferCallback = ListDifferCallback<V>(modelItemList, itemList)
//        val diffResult = DiffUtil.calculateDiff(listDifferCallback)
//
//        modelItemList.addAll(itemList)
//        diffResult.dispatchUpdatesTo(this)
//    }

    abstract val differCallback: DiffUtil.ItemCallback<V>
    val differ : AsyncListDiffer<V> by lazy {
        AsyncListDiffer<V>(this, differCallback)
    }

    override fun onBindViewHolder(holder: BaseRecyclerViewViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount() : Int = differ.currentList.size

    abstract fun onBindData(modelItem: V, binding: T)

}
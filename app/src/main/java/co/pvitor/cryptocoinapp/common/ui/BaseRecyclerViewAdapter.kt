package co.pvitor.cryptocoinapp.common.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import co.pvitor.cryptocoinapp.databinding.RecyclerViewLoadingFooterBinding

@Suppress("UNREACHABLE_CODE", "UnusedEquals")
abstract class BaseRecyclerViewAdapter<T: ViewBinding, V>(
    private val inflate : (LayoutInflater, ViewGroup, Boolean) -> T
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_ITEM = 0
        const val VIEW_TYPE_LOADING = 1
    }

    override fun getItemViewType(position: Int) : Int {
        return if (differ.currentList[position] == null) VIEW_TYPE_LOADING else VIEW_TYPE_ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : RecyclerView.ViewHolder {
        return if(viewType == VIEW_TYPE_LOADING) {
            BaseRecyclerViewLoadingViewHolder(
                RecyclerViewLoadingFooterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        } else {
            BaseRecyclerViewViewHolder<T, V>(
                inflate.invoke(LayoutInflater.from(parent.context), parent, false)
            )
        }

    }

    inner class BaseRecyclerViewLoadingViewHolder(private val binding: RecyclerViewLoadingFooterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.progressBarRvLoading.isIndeterminate = true
        }
    }

    abstract val differCallback: DiffUtil.ItemCallback<V>
    val differ : AsyncListDiffer<V> by lazy {
        AsyncListDiffer<V>(this, differCallback)
    }

    fun showProgress() {
        if(differ.currentList.lastOrNull() != null || differ.currentList.size == 0) {
            val list: MutableList<V?> = differ.currentList.toMutableList()
            list.add(null)
            differ.submitList(list)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder) {
            is BaseRecyclerViewViewHolder<*,*> -> {
                val modelItem = differ.currentList[position]
                onBindData(modelItem, holder.binding as T)
            }
            is BaseRecyclerViewAdapter<*, *>.BaseRecyclerViewLoadingViewHolder -> holder.bind()
        }

    }

    override fun getItemCount() : Int = differ.currentList.size

    abstract fun onBindData(modelItem: V, binding: T)
}


class BaseRecyclerViewViewHolder<T: ViewBinding, V>(val binding: T) : RecyclerView.ViewHolder(binding.root)
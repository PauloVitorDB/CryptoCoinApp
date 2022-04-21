package co.pvitor.cryptocoinapp.util

import androidx.recyclerview.widget.DiffUtil

class ListDifferCallback<T>(
    private val oldList: List<T>,
    private val newList: List<T>
) : DiffUtil.Callback() {

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun getNewListSize(): Int = newList.size

    override fun getOldListSize(): Int = oldList.size

}
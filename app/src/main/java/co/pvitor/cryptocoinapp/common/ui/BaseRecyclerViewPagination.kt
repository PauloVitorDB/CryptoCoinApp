package co.pvitor.cryptocoinapp.common.ui

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewPagination(
    private val layoutManager: LinearLayoutManager,
    private val limitToLoadMoreItems: Int = 1
) : RecyclerView.OnScrollListener() {

    private var currentPage = 1
    private var previousListItemsBound = 0

    private var isLoading = true

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)

        val totalListItemsBound = layoutManager.itemCount

        val lastVisibleItemPositionInList = layoutManager.findLastVisibleItemPosition()

        val boundItemsWasIncreased = (totalListItemsBound > previousListItemsBound)
        if(isLoading && (boundItemsWasIncreased)) {
            isLoading = false
            previousListItemsBound = totalListItemsBound
        }

        val limitReachedToLoadMore = ((lastVisibleItemPositionInList + limitToLoadMoreItems) >= totalListItemsBound)
        if(!isLoading && limitReachedToLoadMore) {
            isLoading = true
            currentPage++
            onLoadItems(currentPage, totalListItemsBound)
        }
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
    }

    abstract fun onLoadItems(currentPage: Int, totalListItemsBound: Int)

}
package co.pvitor.cryptocoinapp.feature_market.presentation.list_coins

import androidx.lifecycle.*
import co.pvitor.cryptocoinapp.common.resources.ApiStatus
import co.pvitor.cryptocoinapp.common.resources.Resource
import co.pvitor.cryptocoinapp.feature_market.domain.model.Coin
import co.pvitor.cryptocoinapp.feature_market.domain.use_case.MarketUseCases
import co.pvitor.cryptocoinapp.feature_market.presentation.list_coins.model.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.lang.IllegalArgumentException
import javax.inject.Inject

@HiltViewModel
class ListCoinsViewModel @Inject constructor(
    private val marketUseCases: MarketUseCases
): ViewModel() {

    private val _state = MutableLiveData<CoinListState>()
    val state = _state as LiveData<CoinListState>

    init {
        _state.value = CoinListState()
        getCoinList(1)
    }

    fun getCoinList(page: Int) {
        marketUseCases.listCoins(page).onEach { resource: Resource<List<Coin>> ->
            when(resource.status)  {
                is ApiStatus.SUCCESS -> {
                    resource.data?.let {
                        val list = _state.value?.coinList
                        list?.addAll(resource.data)
                        _state.value = _state.value?.copy(
                            coinList = list
                        )
                    }
                }
                is ApiStatus.ERROR -> {
                    _state.value = _state.value?.copy(
                        coinList = mutableListOf(),
                        error = resource.message
                    )
                }
                is ApiStatus.LOADING -> {
                    _state.value = _state.value?.copy(
                        isLoading = resource.isLoading
                    )
                }
                else -> throw IllegalArgumentException()
            }
        }.launchIn(viewModelScope)
    }

}
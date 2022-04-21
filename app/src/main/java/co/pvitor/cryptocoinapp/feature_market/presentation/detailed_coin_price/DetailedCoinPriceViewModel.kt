package co.pvitor.cryptocoinapp.feature_market.presentation.detailed_coin_price

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.pvitor.cryptocoinapp.common.resources.ApiStatus
import co.pvitor.cryptocoinapp.common.resources.Resource
import co.pvitor.cryptocoinapp.feature_market.data.data_source.remote.dto.MarketDataDto
import co.pvitor.cryptocoinapp.feature_market.domain.model.CoinMarketData
import co.pvitor.cryptocoinapp.feature_market.domain.use_case.MarketUseCases
import co.pvitor.cryptocoinapp.feature_market.presentation.detailed_coin_price.model.DetailedCoinPriceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailedCoinPriceViewModel @Inject constructor(
    private val marketUseCases: MarketUseCases
) : ViewModel() {

    private val _state = MutableLiveData<DetailedCoinPriceState>()
    val state = _state as LiveData<DetailedCoinPriceState>

    init {
        _state.value = DetailedCoinPriceState()
        getDetailedCoinPrice("bitcoin")
    }

    fun getDetailedCoinPrice(coinID: String) {
        marketUseCases.detailedCoinPrice(coinID).onEach { resource: Resource<CoinMarketData> ->

            when(resource.status) {
                is ApiStatus.SUCCESS -> {
                    _state.value = _state.value?.copy(
                        detailedCoinPrice = resource.data
                    )
                }
                is ApiStatus.ERROR -> {

                }
                is ApiStatus.LOADING -> {

                }
            }

        }.launchIn(viewModelScope)
    }

}
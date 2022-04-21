package co.pvitor.cryptocoinapp.feature_market.domain.use_case.list_coins

import co.pvitor.cryptocoinapp.common.resources.Resource
import co.pvitor.cryptocoinapp.feature_market.data.data_source.remote.dto.toModel
import co.pvitor.cryptocoinapp.feature_market.domain.model.Coin
import co.pvitor.cryptocoinapp.feature_market.domain.repository.CoinRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ListCoins @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(page: Int) : Flow<Resource<List<Coin>>> = flow {

        emit(Resource.Loading(true))

        try {

            val coinList: List<Coin> = repository.getMarketCoins(
                page = page,
                per_page = 100
            ).map { it.toModel() }

            emit(Resource.Success(coinList))

        } catch (e: HttpException) {
            emit(Resource.Error(e.message()))
        } catch (e: IOException) {
            emit(Resource.Error(e.message.toString()))
        }

    }
}
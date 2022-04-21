package co.pvitor.cryptocoinapp.feature_market.domain.use_case.detailed_coin

import co.pvitor.cryptocoinapp.common.resources.Resource
import co.pvitor.cryptocoinapp.feature_market.data.data_source.remote.dto.MarketDataDto
import co.pvitor.cryptocoinapp.feature_market.data.data_source.remote.dto.toModel
import co.pvitor.cryptocoinapp.feature_market.domain.model.CoinMarketData
import co.pvitor.cryptocoinapp.feature_market.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DetailedCoinPrice @Inject constructor(
    private val repository: CoinRepository
) {

   operator fun invoke(coinID: String) : Flow<Resource<CoinMarketData>> = flow {

       emit(Resource.Loading(true))

       try {

            val detailedCoinPrice = repository.getDetailedCoinPrice(
                id = coinID
            )

            emit(Resource.Success(detailedCoinPrice.marketData.toModel("usd")))

       } catch (e: HttpException) {
            emit(Resource.Error(e.message()))
       } catch (e: IOException ) {
            emit(Resource.Error(e.message.toString()))
       } finally {
            emit(Resource.Loading(false))
       }

   }

}
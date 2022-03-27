package co.pvitor.cryptocoinapp.feature_market.data.data_source.remote

import co.pvitor.cryptocoinapp.feature_market.data.data_source.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinGeckoApi {



    @GET("/coins/markets")
    suspend fun getMarketCoins() : List<CoinDto>

    @GET("/coins/{id}")
    suspend fun getCoinById(@Path("id") id: String) : CoinDto

}
package co.pvitor.cryptocoinapp.feature_market.data.data_source.remote

import co.pvitor.cryptocoinapp.feature_market.data.data_source.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinGeckoApi {

    companion object {
        const val BASE_URL = "https://api.coingecko.com/"
        const val API_VERSION = "/api/v3"
    }

    @GET("$API_VERSION/coins/markets")
    suspend fun getMarketCoins(
        @Query("vs_currency") currency: String? = "usd",
        @Query("page") page: Int?,
        @Query("per_page") per_page: Int?
    ) : List<CoinDto>

    @GET("$API_VERSION/coins/{id}")
    suspend fun getCoinById(@Path("id") id: String) : CoinDto

}
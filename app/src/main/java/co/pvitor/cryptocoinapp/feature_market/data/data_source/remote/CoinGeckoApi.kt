package co.pvitor.cryptocoinapp.feature_market.data.data_source.remote

import co.pvitor.cryptocoinapp.feature_market.data.data_source.remote.dto.CoinDto
import co.pvitor.cryptocoinapp.feature_market.data.data_source.remote.dto.DetailedCoinPriceDto
import retrofit2.http.GET
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
        @Query("per_page") perPage: Int?
    ) : List<CoinDto>

    @GET("$API_VERSION/coins/{id}")
    suspend fun getDetailedCoinPriceById(
        @Path("id") id: String,
        @Query("tickers") tickers: Boolean? = false,
        @Query("community_data") communityData: Boolean? = false,
        @Query("developer_data") developerData: Boolean? = false
    ) : DetailedCoinPriceDto

}
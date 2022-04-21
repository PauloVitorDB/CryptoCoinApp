package co.pvitor.cryptocoinapp.di

import co.pvitor.cryptocoinapp.feature_market.data.data_source.remote.CoinGeckoApi
import co.pvitor.cryptocoinapp.feature_market.data.data_source.remote.CoinGeckoApi.Companion.BASE_URL
import co.pvitor.cryptocoinapp.feature_market.data.repository.CoinRepositoryImpl
import co.pvitor.cryptocoinapp.feature_market.domain.repository.CoinRepository
import co.pvitor.cryptocoinapp.feature_market.domain.use_case.MarketUseCases
import co.pvitor.cryptocoinapp.feature_market.domain.use_case.detailed_coin.DetailedCoinPrice
import co.pvitor.cryptocoinapp.feature_market.domain.use_case.list_coins.ListCoins
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinGeckoApi() : CoinGeckoApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinGeckoApi::class.java)

    @Provides
    @Singleton
    fun provideCoinRepository(dataSource: CoinGeckoApi) : CoinRepository {
        return CoinRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun provideMarketUseCases(repository: CoinRepository) : MarketUseCases {
        return MarketUseCases(
            listCoins = ListCoins(repository),
            detailedCoinPrice = DetailedCoinPrice(repository)
        )
    }

}
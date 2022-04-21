package co.pvitor.cryptocoinapp.feature_market.domain.model

data class CoinMarketData(
    val currentPrice: String,
    val marketCapRank: Int,
    val marketCap: String,
    val high24h: String,
    val fullyDilutedValuation: String,
    val low24h: String,
    val totalSupply: String,
    val maxSupply: String,
    val circulatingSupply: String,
    val totalVolume: String
)
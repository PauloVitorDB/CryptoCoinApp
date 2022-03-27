package co.pvitor.cryptocoinapp.feature_market.data.common

sealed class ApiStatus {

    object SUCCESS: ApiStatus()
    object ERROR: ApiStatus()
    object LOADING: ApiStatus()

}

package co.pvitor.cryptocoinapp.common.resources

sealed class ApiStatus {

    object SUCCESS: ApiStatus()
    object ERROR: ApiStatus()
    object LOADING: ApiStatus()

}

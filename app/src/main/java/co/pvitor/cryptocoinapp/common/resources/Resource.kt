package co.pvitor.cryptocoinapp.common.resources

sealed class Resource<out D>(
    val data: D? = null,
    val status: ApiStatus? = null,
    val isLoading: Boolean = false,
    val message: String? = null
) {

    data class Success<out T>(val _data: T?) : Resource<T>(
        data = _data,
        status = ApiStatus.SUCCESS
    )

    data class Error(val exception: String) : Resource<Nothing>(
        null,
        status = ApiStatus.ERROR,
        message = exception
    )

    data class Loading(val _isLoading: Boolean) : Resource<Nothing>(
        null,
        status = ApiStatus.LOADING,
        isLoading = _isLoading
    )

}
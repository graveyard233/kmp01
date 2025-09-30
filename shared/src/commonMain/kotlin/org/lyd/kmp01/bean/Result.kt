package org.lyd.kmp01.bean

sealed interface Result<out T> {
    data class Success<T>(val data: T) : Result<T>
    data class Error(val error: String) : Result<Nothing>
    data object Loading : Result<Nothing>
}
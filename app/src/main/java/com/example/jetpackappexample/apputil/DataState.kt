package com.example.jetpackappexample.apputil

/**
 * Data state for processing api response Loading, Success and Error
 */
sealed class DataState<out R> {
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val exception: String?) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}
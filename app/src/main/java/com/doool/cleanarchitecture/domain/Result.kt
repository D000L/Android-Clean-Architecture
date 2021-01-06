package com.doool.cleanarchitecture.domain

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Fail(val error: ErrorModel) : Result<Nothing>()
}
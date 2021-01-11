package com.doool.cleanarchitecture.domain

sealed class ResultModel<out T> {
    data class Success<out T>(val data: T) : ResultModel<T>()
    data class Fail(val error: ErrorModel) : ResultModel<Nothing>()
}
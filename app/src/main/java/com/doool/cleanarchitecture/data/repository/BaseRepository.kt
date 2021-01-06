package com.doool.cleanarchitecture.data.repository

import com.doool.cleanarchitecture.data.mapper.EntityMapper
import com.doool.cleanarchitecture.data.model.Entity
import com.doool.cleanarchitecture.domain.ErrorModel
import com.doool.cleanarchitecture.domain.Result
import com.doool.cleanarchitecture.domain.model.Model
import com.google.gson.JsonParser
import retrofit2.HttpException

open class BaseRepository {

    private fun createUnknownError() = ErrorModel(-1, "Unknown Error")

    private fun parseError(throwable: Throwable): ErrorModel {
        return try {
            val errorJson = (throwable as HttpException).response()?.errorBody()?.string()
            val errorDetail = JsonParser().parse(errorJson).asJsonObject["detail"].toString()
            ErrorModel(-1, errorDetail)
        } catch (throwable: Throwable) {
            createUnknownError()
        }
    }

    private inline fun <T> withTryCatch(api: () -> T): Result<T> {
        return try {
            Result.Success(api())
        } catch (throwable: Throwable) {
            Result.Fail(parseError(throwable))
        }
    }

    suspend fun requestNoResponseApi(api: suspend () -> Unit): Result<Unit> {
        return withTryCatch { api() }
    }

    suspend fun <M : Model, EM : Entity> requestApi(
        mapping: EntityMapper<M, EM>,
        api: suspend () -> EM
    ): Result<M> {
        return withTryCatch { mapping.mapToModel(api()) }
    }

    suspend fun <M> requestApi(api: suspend () -> M): Result<M> {
        return withTryCatch {
            api()
        }
    }
}
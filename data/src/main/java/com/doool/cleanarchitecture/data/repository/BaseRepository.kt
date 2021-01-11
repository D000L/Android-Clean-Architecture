package com.doool.cleanarchitecture.data.repository

import com.doool.cleanarchitecture.data.mapper.EntityMapper
import com.doool.cleanarchitecture.data.model.Entity
import com.doool.cleanarchitecture.domain.ErrorModel
import com.doool.cleanarchitecture.domain.ResultModel
import com.doool.cleanarchitecture.domain.model.Model
import retrofit2.HttpException

open class BaseRepository {

    private fun createUnknownError() = ErrorModel(-1, "Unknown Error")

    private fun parseError(throwable: Throwable): ErrorModel {
        return try {
            (throwable as HttpException).run {
                val errorJson = response()?.errorBody()?.string()
                ErrorModel(code(), errorJson.toString())
            }
        } catch (throwable: Throwable) {
            createUnknownError()
        }
    }

    private inline fun <T> withTryCatch(api: () -> T): ResultModel<T> {
        return try {
            ResultModel.Success(api())
        } catch (throwable: Throwable) {
            ResultModel.Fail(parseError(throwable))
        }
    }

    suspend fun <EM : Entity, M : Model> requestApi(
        mapping: EntityMapper<EM, M>,
        api: suspend () -> EM
    ): ResultModel<M> {
        return withTryCatch { mapping.mapToModel(api()) }
    }

    suspend fun <M> requestApi(api: suspend () -> M): ResultModel<M> {
        return withTryCatch {
            api()
        }
    }
}
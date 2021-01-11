package com.doool.cleanarchitecture.domain.usecase

import com.doool.cleanarchitecture.domain.ResultModel
import kotlinx.coroutines.flow.flow

abstract class BaseParamUseCase<T, P> {

    protected abstract suspend fun run(params: P): ResultModel<T>

    suspend operator fun invoke(params: P) = flow { emit(run(params)) }
}
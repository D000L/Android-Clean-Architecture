package com.doool.cleanarchitecture.domain.usecase

import com.doool.cleanarchitecture.domain.Result
import kotlinx.coroutines.flow.flow

abstract class BaseParamUseCase<T, P> {

    protected abstract suspend fun run(params: P): Result<T>

    suspend operator fun invoke(params: P) = flow { emit(run(params)) }
}
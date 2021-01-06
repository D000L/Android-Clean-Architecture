package com.doool.cleanarchitecture.domain.usecase

import com.doool.cleanarchitecture.domain.Result
import kotlinx.coroutines.flow.flow

abstract class BaseUseCase<T> {

    protected abstract suspend fun run(): Result<T>

    suspend operator fun invoke() = flow { emit(run()) }
}
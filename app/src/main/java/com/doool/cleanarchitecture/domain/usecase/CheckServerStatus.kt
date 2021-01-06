package com.doool.cleanarchitecture.domain.usecase

import com.doool.cleanarchitecture.domain.Result
import com.doool.cleanarchitecture.domain.model.ServerStatus
import com.doool.cleanarchitecture.domain.repository.PublicApiRepository
import javax.inject.Inject

class CheckServerStatus @Inject constructor(private val publicApiRepository: PublicApiRepository) :
    BaseUseCase<ServerStatus>() {

    override suspend fun run(): Result<ServerStatus> {
        return publicApiRepository.getServerStatus()
    }
}
package com.doool.cleanarchitecture.domain.usecase

import com.doool.cleanarchitecture.domain.Result
import com.doool.cleanarchitecture.domain.repository.PublicApiRepository
import javax.inject.Inject

class GetAllCategory @Inject constructor(private val publicApiRepository: PublicApiRepository) :
    BaseUseCase<List<String>>() {

    override suspend fun run(): Result<List<String>> {
        return publicApiRepository.getAllCategories()
    }
}
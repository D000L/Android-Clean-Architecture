package com.doool.cleanarchitecture.domain.usecase

import com.doool.cleanarchitecture.domain.Result
import com.doool.cleanarchitecture.domain.repository.PublicApiRepository
import javax.inject.Inject

class GetAllCategory @Inject constructor(private val publicApiRepository: PublicApiRepository) :
    BaseParamUseCase<List<String>, GetAllCategory.Params>() {

    enum class Sort {
        ASC, DESC
    }

    data class Params(val sort: Sort = Sort.ASC)

    override suspend fun run(params: Params): Result<List<String>> {
        return when (val result = publicApiRepository.getAllCategories()) {
            is Result.Success -> {
                if (params.sort == Sort.ASC) {
                    Result.Success(result.data.sorted())
                } else {
                    Result.Success(result.data.sortedDescending())
                }
            }
            is Result.Fail -> result
        }
    }
}
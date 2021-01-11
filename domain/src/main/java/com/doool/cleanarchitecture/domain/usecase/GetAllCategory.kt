package com.doool.cleanarchitecture.domain.usecase

import com.doool.cleanarchitecture.domain.ResultModel
import com.doool.cleanarchitecture.domain.repository.PublicApiRepository
import javax.inject.Inject

class GetAllCategory @Inject constructor(private val publicApiRepository: PublicApiRepository) :
    BaseParamUseCase<List<String>, GetAllCategory.Params>() {

    enum class Sort {
        ASC, DESC
    }

    data class Params(val sort: Sort = Sort.ASC)

    override suspend fun run(params: Params): ResultModel<List<String>> {
        return when (val result = publicApiRepository.getAllCategories()) {
            is ResultModel.Success -> {
                if (params.sort == Sort.ASC) {
                    ResultModel.Success(result.data.sorted())
                } else {
                    ResultModel.Success(result.data.sortedDescending())
                }
            }
            is ResultModel.Fail -> result
        }
    }
}
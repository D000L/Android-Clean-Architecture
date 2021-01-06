package com.doool.cleanarchitecture.domain.usecase

import com.doool.cleanarchitecture.domain.Result
import com.doool.cleanarchitecture.domain.model.Entries
import com.doool.cleanarchitecture.domain.model.Entry
import com.doool.cleanarchitecture.domain.repository.PublicApiRepository
import javax.inject.Inject

class GetRandomPublicApi @Inject constructor(private val publicApiRepository: PublicApiRepository) :
    BaseParamUseCase<Entry?, GetRandomPublicApi.Params>() {

    data class Params(
        val title: String? = null,
        val password: String? = null,
        val auth: String? = null,
        val https: Boolean? = null,
        val cors: String? = null,
        val category: String? = null
    )

    override suspend fun run(params: Params): Result<Entry?> {
        val result = publicApiRepository.getRandomEntry(
            params.title,
            params.password,
            params.auth,
            params.https,
            params.cors,
            params.category
        )
        return when (result) {
            is Result.Success -> {
                Result.Success(result.data.entries.getOrNull(0))
            }
            is Result.Fail -> {
                Result.Fail(result.error)
            }
        }
    }
}
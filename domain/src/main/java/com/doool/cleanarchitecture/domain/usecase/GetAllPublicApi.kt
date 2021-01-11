package com.doool.cleanarchitecture.domain.usecase

import com.doool.cleanarchitecture.domain.ResultModel
import com.doool.cleanarchitecture.domain.model.Entries
import com.doool.cleanarchitecture.domain.repository.PublicApiRepository
import javax.inject.Inject

class GetAllPublicApi @Inject constructor(private val publicApiRepository: PublicApiRepository) :
    BaseParamUseCase<Entries, GetAllPublicApi.Params>() {

    data class Params(
        val title: String? = null,
        val password: String? = null,
        val auth: String? = null,
        val https: Boolean? = null,
        val cors: String? = null,
        val category: String? = null
    )

    override suspend fun run(params: Params): ResultModel<Entries> {
        return publicApiRepository.getEntries(
            params.title,
            params.password,
            params.auth,
            params.https,
            params.cors,
            params.category
        )
    }
}
package com.doool.cleanarchitecture.data.repository

import com.doool.cleanarchitecture.data.mapper.EntriesMapper
import com.doool.cleanarchitecture.data.mapper.ServerStatusMapper
import com.doool.cleanarchitecture.data.service.PublicApiService
import com.doool.cleanarchitecture.domain.Result
import com.doool.cleanarchitecture.domain.model.Entries
import com.doool.cleanarchitecture.domain.model.ServerStatus
import com.doool.cleanarchitecture.domain.repository.PublicApiRepository
import javax.inject.Inject

class PublicApiRepositoryImpl @Inject constructor(
    private val publicApiService: PublicApiService,
    private val entriesMapper: EntriesMapper,
    private val serverStatusMapper: ServerStatusMapper
) : BaseRepository(), PublicApiRepository {

    override suspend fun getEntries(
        title: String?,
        password: String?,
        auth: String?,
        https: Boolean?,
        cors: String?,
        category: String?
    ): Result<Entries> {
        return requestApi(entriesMapper) {
            publicApiService.getEntries(
                title,
                password,
                auth,
                https,
                cors,
                category
            )
        }
    }

    override suspend fun getRandomEntry(
        title: String?,
        password: String?,
        auth: String?,
        https: Boolean?,
        cors: String?,
        category: String?
    ): Result<Entries> {
        return requestApi(entriesMapper) {
            publicApiService.getRandomEntry(
                title,
                password,
                auth,
                https,
                cors,
                category
            )
        }
    }

    override suspend fun getAllCategories(): Result<List<String>> {
        return requestApi { publicApiService.getAllCategories() }
    }

    override suspend fun getServerStatus(): Result<ServerStatus> {
        return requestApi(serverStatusMapper) { publicApiService.getServerStatus() }
    }
}
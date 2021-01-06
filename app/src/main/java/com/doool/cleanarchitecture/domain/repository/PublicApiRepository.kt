package com.doool.cleanarchitecture.domain.repository

import com.doool.cleanarchitecture.domain.model.Entries
import com.doool.cleanarchitecture.domain.model.ServerStatus
import com.doool.cleanarchitecture.domain.Result

interface PublicApiRepository {

    suspend fun getEntries(
        title: String? = null,
        password: String? = null,
        auth: String? = null,
        https: Boolean? = null,
        cors: String? = null,
        category: String? = null
    ): Result<Entries>

    suspend fun getRandomEntry(
        title: String? = null,
        password: String? = null,
        auth: String? = null,
        https: Boolean? = null,
        cors: String? = null,
        category: String? = null
    ): Result<Entries>

    suspend fun getAllCategories(): Result<List<String>>
    suspend fun getServerStatus(): Result<ServerStatus>
}
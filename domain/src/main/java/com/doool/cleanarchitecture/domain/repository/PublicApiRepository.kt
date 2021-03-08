package com.doool.cleanarchitecture.domain.repository

import com.doool.cleanarchitecture.domain.model.Entries
import com.doool.cleanarchitecture.domain.model.ServerStatus
import com.doool.cleanarchitecture.domain.ResultModel

interface PublicApiRepository {

    suspend fun getEntries(
        title: String? = null,
        description: String? = null,
        auth: String? = null,
        https: Boolean? = null,
        cors: String? = null,
        category: String? = null
    ): ResultModel<Entries>

    suspend fun getRandomEntry(
        title: String? = null,
        description: String? = null,
        auth: String? = null,
        https: Boolean? = null,
        cors: String? = null,
        category: String? = null
    ): ResultModel<Entries>

    suspend fun getAllCategories(): ResultModel<List<String>>
    suspend fun getServerStatus(): ResultModel<ServerStatus>
}
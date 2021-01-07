package com.doool.cleanarchitecture.data.mapper

import com.doool.cleanarchitecture.data.model.ServerStatusEntity
import com.doool.cleanarchitecture.domain.model.ServerStatus
import javax.inject.Inject

class ServerStatusMapper @Inject constructor() : EntityMapper<ServerStatusEntity, ServerStatus> {
    override fun mapToModel(entity: ServerStatusEntity) = with(entity) {
        ServerStatus(alive)
    }
}
package com.doool.cleanarchitecture.data.mapper

import com.doool.cleanarchitecture.data.model.ServerStatusEntity
import com.doool.cleanarchitecture.domain.model.ServerStatus
import com.doool.cleanarchitecture.ui.mapper.EntityMapper
import javax.inject.Inject

class ServerStatusMapper @Inject constructor() : EntityMapper<ServerStatus, ServerStatusEntity>() {
    override fun mapToModel(entity: ServerStatusEntity) = with(entity) {
        ServerStatus(alive)
    }

    override fun mapToEntity(model: ServerStatus) = with(model) {
        ServerStatusEntity(alive)
    }
}
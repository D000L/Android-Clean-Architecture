package com.doool.cleanarchitecture.presentation.mapper

import com.doool.cleanarchitecture.domain.model.ServerStatus
import com.doool.cleanarchitecture.presentation.model.ServerStatusItem
import javax.inject.Inject

class ServerStatusMapper @Inject constructor() : ModelMapper<ServerStatus, ServerStatusItem> {

    override fun mapToItem(model: ServerStatus): ServerStatusItem = with(model) {
        ServerStatusItem(alive)
    }
}
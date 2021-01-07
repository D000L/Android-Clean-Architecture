package com.doool.cleanarchitecture.ui.mapper

import com.doool.cleanarchitecture.domain.model.ServerStatus
import com.doool.cleanarchitecture.ui.model.ServerStatusItem
import javax.inject.Inject

class ServerStatusMapper @Inject constructor() : ModelMapper<ServerStatus, ServerStatusItem> {

    override fun mapToItem(model: ServerStatus): ServerStatusItem = with(model) {
        ServerStatusItem(alive)
    }
}
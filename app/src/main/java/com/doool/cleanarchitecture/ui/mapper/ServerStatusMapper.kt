package com.doool.cleanarchitecture.ui.mapper

import com.doool.cleanarchitecture.domain.model.ServerStatus
import com.doool.cleanarchitecture.ui.model.ServerStatusItem
import javax.inject.Inject

class ServerStatusMapper @Inject constructor() : ItemMapper<ServerStatus, ServerStatusItem>() {

    override fun mapToItem(model: ServerStatus): ServerStatusItem = with(model) {
        ServerStatusItem(alive)
    }

    override fun mapToModel(item: ServerStatusItem): ServerStatus = with(item) {
        ServerStatus(alive)
    }
}
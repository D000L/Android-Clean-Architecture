package com.doool.cleanarchitecture.data.mapper

import com.doool.cleanarchitecture.data.model.EntryEntity
import com.doool.cleanarchitecture.domain.model.Entry
import javax.inject.Inject

class EntryMapper @Inject constructor(): EntityMapper<Entry, EntryEntity>() {
    override fun mapToModel(entity: EntryEntity) = with(entity) {
        Entry(api, description, auth, https, cors, link, category)
    }

    override fun mapToEntity(model: Entry) = with(model) {
        EntryEntity(api, description, auth, https, cors, link, category)
    }
}
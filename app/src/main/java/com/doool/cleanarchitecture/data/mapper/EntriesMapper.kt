package com.doool.cleanarchitecture.data.mapper

import com.doool.cleanarchitecture.data.model.EntriesEntity
import com.doool.cleanarchitecture.domain.model.Entries
import javax.inject.Inject

class EntriesMapper @Inject constructor(private val entryMapper: EntryMapper) :
    EntityMapper<Entries, EntriesEntity>() {
    override fun mapToModel(entity: EntriesEntity) = with(entity) {
        Entries(count, entries.map {
            entryMapper
                .mapToModel(it)
        })
    }

    override fun mapToEntity(model: Entries) = with(model) {
        EntriesEntity(count, entries.map {
            entryMapper
                .mapToEntity(it)
        })
    }
}
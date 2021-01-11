package com.doool.cleanarchitecture.data.mapper

import com.doool.cleanarchitecture.data.model.EntriesEntity
import com.doool.cleanarchitecture.domain.model.Entries
import javax.inject.Inject

internal class EntriesMapper @Inject constructor(private val entryMapper: EntryMapper) :
    EntityMapper<EntriesEntity, Entries> {
    override fun mapToModel(entity: EntriesEntity) = with(entity) {
        Entries(count, entries.map {
            entryMapper
                .mapToModel(it)
        })
    }
}
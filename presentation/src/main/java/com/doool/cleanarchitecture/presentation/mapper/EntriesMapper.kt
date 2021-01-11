package com.doool.cleanarchitecture.presentation.mapper

import com.doool.cleanarchitecture.domain.model.Entries
import com.doool.cleanarchitecture.presentation.model.EntriesItem
import javax.inject.Inject

class EntriesMapper @Inject constructor(private val entryMapper: EntryMapper) :
    ModelMapper<Entries, EntriesItem> {

    override fun mapToItem(model: Entries): EntriesItem = with(model) {
        EntriesItem(count, entries.map {
            entryMapper
                .mapToItem(it)
        })
    }
}
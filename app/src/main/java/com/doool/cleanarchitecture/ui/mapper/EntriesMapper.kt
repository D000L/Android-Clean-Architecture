package com.doool.cleanarchitecture.ui.mapper

import com.doool.cleanarchitecture.domain.model.Entries
import com.doool.cleanarchitecture.ui.model.EntriesItem
import javax.inject.Inject

class EntriesMapper @Inject constructor(private val entryMapper: EntryMapper) :
    ItemMapper<Entries, EntriesItem>() {

    override fun mapToItem(model: Entries): EntriesItem = with(model) {
        EntriesItem(count, entries.map {
            entryMapper
                .mapToItem(it)
        })
    }

    override fun mapToModel(item: EntriesItem): Entries = with(item) {
        Entries(count, entries.map {
            entryMapper
                .mapToModel(it)
        })
    }
}
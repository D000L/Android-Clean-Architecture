package com.doool.cleanarchitecture.ui.mapper

import com.doool.cleanarchitecture.domain.model.Entry
import com.doool.cleanarchitecture.ui.model.EntryItem
import javax.inject.Inject

class EntryMapper @Inject constructor() : ItemMapper<Entry, EntryItem>() {
    override fun mapToItem(model: Entry): EntryItem = with(model) {
        EntryItem(api, description, auth, https, cors, link, category)
    }

    override fun mapToModel(item: EntryItem): Entry = with(item) {
        Entry(api, description, auth, https, cors, link, category)
    }
}
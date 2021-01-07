package com.doool.cleanarchitecture.ui.mapper

import com.doool.cleanarchitecture.domain.model.Entry
import com.doool.cleanarchitecture.ui.model.EntryItem
import javax.inject.Inject

class EntryMapper @Inject constructor() : ModelMapper<Entry, EntryItem> {

    override fun mapToItem(model: Entry): EntryItem = with(model) {
        EntryItem(api, description, auth, https, cors, link, category)
    }
}
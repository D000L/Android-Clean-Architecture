package com.doool.cleanarchitecture.ui.model

data class EntriesItem(
    val count: Int,
    val entries: List<EntryItem>
) : Item()
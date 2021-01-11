package com.doool.cleanarchitecture.presentation.model

data class EntriesItem(
    val count: Int,
    val entries: List<EntryItem>
) : Item()
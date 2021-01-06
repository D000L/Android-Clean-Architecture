package com.doool.cleanarchitecture.data.model

data class EntriesEntity(
    val count: Int,
    val entries: List<EntryEntity>
): Entity()
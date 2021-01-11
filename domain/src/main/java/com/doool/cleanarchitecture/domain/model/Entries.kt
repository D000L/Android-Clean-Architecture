package com.doool.cleanarchitecture.domain.model

data class Entries(
    val count: Int,
    val entries: List<Entry>
) : Model()
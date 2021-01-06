package com.doool.cleanarchitecture.domain.model

data class Entry(
    val api: String,
    val description: String,
    val auth: String,
    val https: Boolean,
    val cors: String,
    val link: String,
    val category: String
) : Model()



package com.doool.cleanarchitecture.presentation.model

data class EntryItem(
    val api: String,
    val description: String,
    val auth: String,
    val https: Boolean,
    val cors: String,
    val link: String,
    val category: String
) : Item()



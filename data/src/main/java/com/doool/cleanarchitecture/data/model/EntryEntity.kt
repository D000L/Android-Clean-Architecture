package com.doool.cleanarchitecture.data.model

import com.google.gson.annotations.SerializedName

data class EntryEntity(
    @SerializedName("API") val api: String,
    @SerializedName("Description") val description: String,
    @SerializedName("Auth") val auth: String,
    @SerializedName("HTTPS") val https: Boolean,
    @SerializedName("Cors") val cors: String,
    @SerializedName("Link") val link: String,
    @SerializedName("Category") val category: String
) : Entity()



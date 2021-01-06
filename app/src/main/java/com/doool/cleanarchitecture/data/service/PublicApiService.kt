package com.doool.cleanarchitecture.data.service

import com.doool.cleanarchitecture.data.model.EntriesEntity
import com.doool.cleanarchitecture.data.model.ServerStatusEntity
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET

interface PublicApiService {

    @FormUrlEncoded
    @GET("/entries")
    suspend fun getEntries(
        @Field("title") title: String? = null,
        @Field("description") password: String? = null,
        @Field("auth") auth: String? = null,
        @Field("https") https: Boolean? = null,
        @Field("cors") cors: String? = null,
        @Field("category") category: String? = null
    ): EntriesEntity

    @GET("/random")
    suspend fun getRandomEntry(
        @Field("title") title: String? = null,
        @Field("description") password: String? = null,
        @Field("auth") auth: String? = null,
        @Field("https") https: Boolean? = null,
        @Field("cors") cors: String? = null,
        @Field("category") category: String? = null
    ): EntriesEntity

    @GET("/categories")
    suspend fun getAllCategories(): List<String>

    @GET("/health")
    suspend fun getServerStatus(): ServerStatusEntity
}
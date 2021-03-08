package com.doool.cleanarchitecture.data.service

import com.doool.cleanarchitecture.data.model.EntriesEntity
import com.doool.cleanarchitecture.data.model.ServerStatusEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface PublicApiService {

   @GET("/entries")
    suspend fun getEntries(
       @Query("title") title: String? = null,
       @Query("description") description: String? = null,
       @Query("auth") auth: String? = null,
       @Query("https") https: Boolean? = null,
       @Query("cors") cors: String? = null,
       @Query("category") category: String? = null
    ): EntriesEntity

    @GET("/random")
    suspend fun getRandomEntry(
        @Query("title") title: String? = null,
        @Query("description") description: String? = null,
        @Query("auth") auth: String? = null,
        @Query("https") https: Boolean? = null,
        @Query("cors") cors: String? = null,
        @Query("category") category: String? = null
    ): EntriesEntity

    @GET("/categories")
    suspend fun getAllCategories(): List<String>

    @GET("/health")
    suspend fun getServerStatus(): ServerStatusEntity
}
package com.doool.cleanarchitecture.data.module

import com.doool.cleanarchitecture.data.service.PublicApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
internal class ServiceModule {

    @Provides
    fun providePublicApiService(retrofit: Retrofit): PublicApiService = retrofit.create(
        PublicApiService::class.java)
}
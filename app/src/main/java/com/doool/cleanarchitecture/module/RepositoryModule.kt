package com.doool.cleanarchitecture.module

import com.doool.cleanarchitecture.data.repository.PublicApiRepositoryImpl
import com.doool.cleanarchitecture.domain.repository.PublicApiRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Binds
    abstract fun bindPublicApiRepository(userRepository: PublicApiRepositoryImpl): PublicApiRepository
}
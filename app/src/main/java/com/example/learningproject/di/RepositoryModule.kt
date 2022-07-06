package com.example.learningproject.di

import com.example.learningproject.data.remote.PostApi
import com.example.learningproject.repository.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideLoginRepository(
        api: PostApi,
    ): PostRepository {
        return PostRepository(api)
    }

}

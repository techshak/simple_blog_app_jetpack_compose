package com.example.learningproject.di

import com.example.learningproject.data.local.PostDatabase
import com.example.learningproject.data.remote.PostApi
import com.example.learningproject.repository.comment.CommentRepository
import com.example.learningproject.repository.comment.CommentRepositoryImpl
import com.example.learningproject.repository.post.PostRepository
import com.example.learningproject.repository.post.PostRepositoryImpl
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
    fun providePostRepository(
        api: PostApi,
        postDatabase: PostDatabase
    ): PostRepository {
        return PostRepositoryImpl(api,postDatabase)
    }

    @Singleton
    @Provides
    fun provideCommentsRepository(
        api: PostApi,
    ): CommentRepository {
        return CommentRepositoryImpl(api)
    }

}

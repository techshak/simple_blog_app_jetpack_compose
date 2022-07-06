package com.example.learningproject.di

import android.content.Context
import androidx.room.Room
import com.example.learningproject.data.local.PostDao
import com.example.learningproject.data.local.PostDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object LocalModule {

    @Singleton
    @Provides
    fun providesFavouritesDataBase(@ApplicationContext context: Context): PostDatabase {
        return Room.databaseBuilder(
            context,
            PostDatabase::class.java,
            PostDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providesLastLogsDao(postDatabase: PostDatabase): PostDao {
        return postDatabase.getPostsDao()
    }
}

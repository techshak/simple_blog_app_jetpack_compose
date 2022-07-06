package com.example.learningproject.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.learningproject.data.remote.dto.PostInfoDto

@Database(
    entities =[PostInfoDto::class],
    version = 1,
    exportSchema = false
)
abstract class PostDatabase : RoomDatabase(){
    abstract fun getPostsDao() : PostDao

    companion object {
        var DATABASE_NAME: String = "post_cache_db"
    }
}
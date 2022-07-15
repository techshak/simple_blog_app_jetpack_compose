package com.example.learningproject.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.learningproject.data.remote.dto.PostInfoDto

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(postInfoDto: PostInfoDto)

    @Query("DELETE From `favourites`")
    suspend fun deleteFavourite()
}
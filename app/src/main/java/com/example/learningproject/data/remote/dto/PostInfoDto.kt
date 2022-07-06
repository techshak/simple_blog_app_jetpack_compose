package com.example.learningproject.data.remote.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PostInfoDto (
    val body: String,
    @PrimaryKey val id: Int,
    val title: String,
    val userId: Int
        )
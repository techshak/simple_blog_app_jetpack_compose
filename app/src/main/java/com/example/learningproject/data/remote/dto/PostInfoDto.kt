package com.example.learningproject.data.remote.dto

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "favourites")
@Parcelize
data class PostInfoDto (
    val body: String,
    @PrimaryKey
    val id: Int,
    val title: String,
    val userId: Int
        ) : Parcelable
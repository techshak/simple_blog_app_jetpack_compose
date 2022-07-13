package com.example.learningproject.data.remote.dto

data class CommentDto(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)
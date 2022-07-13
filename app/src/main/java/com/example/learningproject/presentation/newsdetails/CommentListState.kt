package com.example.learningproject.presentation.newsdetails

import com.example.learningproject.data.remote.dto.CommentDto

data class CommentListState (
    val commentList: List<CommentDto> = emptyList(),
    val isLoading: Boolean = false,
)
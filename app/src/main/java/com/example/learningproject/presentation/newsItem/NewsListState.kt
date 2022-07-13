package com.example.learningproject.presentation.newsItem

import com.example.learningproject.data.remote.dto.PostInfoDto

data class NewsListState (
    val postList: List<PostInfoDto> = emptyList(),
    val isLoading: Boolean = false,
        )
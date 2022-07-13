package com.example.learningproject.repository.post

import com.example.learningproject.data.remote.dto.PostInfoDto
import com.example.learningproject.utils.Resource
import kotlinx.coroutines.flow.Flow

interface PostRepository{
    suspend fun getPosts(): Flow<Resource<List<PostInfoDto>>>

}
package com.example.learningproject.repository.comment

import com.example.learningproject.data.remote.dto.CommentDto
import com.example.learningproject.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CommentRepository {
    suspend fun getComments(id:Int): Flow<Resource<List<CommentDto>>>
}
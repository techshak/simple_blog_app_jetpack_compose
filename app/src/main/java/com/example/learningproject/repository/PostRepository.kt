package com.example.learningproject.repository

import com.example.learningproject.data.remote.PostApi
import com.example.learningproject.data.remote.dto.PostInfoDto
import com.example.learningproject.utils.ApiCallHandler
import com.example.learningproject.utils.Resource
import javax.inject.Inject

class PostRepository @Inject constructor(private val api: PostApi){
    suspend fun getPosts():Resource<List<PostInfoDto>> {
        return ApiCallHandler.safeApiCall { api.getPosts() }
    }

}
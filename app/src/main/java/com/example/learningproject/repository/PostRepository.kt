package com.example.learningproject.repository

import com.example.learningproject.data.remote.PostApi
import javax.inject.Inject

class PostRepository @Inject constructor(private val api: PostApi){
    suspend fun getPosts() = api.getPosts()

}
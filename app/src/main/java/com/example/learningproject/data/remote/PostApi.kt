package com.example.learningproject.data.remote

import com.example.learningproject.data.remote.dto.PostInfoDto
import retrofit2.http.GET

interface PostApi {
    @GET("posts")
    suspend fun getPosts():ArrayList<PostInfoDto>
    companion object{
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

}
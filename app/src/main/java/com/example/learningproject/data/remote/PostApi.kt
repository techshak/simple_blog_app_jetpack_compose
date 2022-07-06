package com.example.learningproject.data.remote

import com.example.learningproject.data.remote.dto.Test
import retrofit2.Response
import retrofit2.http.GET

interface PostApi {
    @GET("posts")
    suspend fun getPosts(): Response<Test>
    companion object{
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

}
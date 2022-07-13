package com.example.learningproject.data.remote

import com.example.learningproject.data.remote.dto.CommentDto
import com.example.learningproject.data.remote.dto.PostInfoDto
import com.example.learningproject.data.remote.dto.Test
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApi {

    @GET("posts")
    suspend fun getPosts(): List<PostInfoDto>

    @GET("posts/{id}/comments")
    suspend fun getComments(@Path("id") id:Int):List<CommentDto>

    companion object{
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

}
package com.example.learningproject.repository.post

import com.example.learningproject.data.local.PostDatabase
import com.example.learningproject.data.remote.PostApi
import com.example.learningproject.data.remote.dto.PostInfoDto
import com.example.learningproject.repository.post.PostRepository
import com.example.learningproject.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRepositoryImpl @Inject constructor(
    private val api : PostApi,
    private val postDatabase: PostDatabase
): PostRepository {
    override suspend fun getPosts(): Flow<Resource<List<PostInfoDto>>>{
      return flow{
            emit(Resource.Loading(true))
            val posts = try {
                val result = api.getPosts()
                emit(Resource.Success(result))
                emit(Resource.Loading(false))
            }catch(e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            }
      }
    }

    override suspend fun insertFavourite(postInfoDto: PostInfoDto) =
        postDatabase.getPostsDao().upsert(postInfoDto)


}
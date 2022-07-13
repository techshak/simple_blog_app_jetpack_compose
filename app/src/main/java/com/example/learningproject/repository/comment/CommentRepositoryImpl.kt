package com.example.learningproject.repository.comment

import com.example.learningproject.data.remote.PostApi
import com.example.learningproject.data.remote.dto.CommentDto
import com.example.learningproject.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CommentRepositoryImpl @Inject constructor(
        private val api : PostApi
    ):CommentRepository {
        override suspend fun getComments(id:Int): Flow<Resource<List<CommentDto>>> {
            return flow{
                emit(Resource.Loading(true))
                val posts = try {
                    val result = api.getComments(id)
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
}
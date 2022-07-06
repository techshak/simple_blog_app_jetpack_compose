package com.example.learningproject.presentation.newsItem

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningproject.data.remote.dto.PostInfoDto
import com.example.learningproject.data.remote.dto.Test
import com.example.learningproject.repository.PostRepository
import com.example.learningproject.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class NewsItemViewModel @Inject constructor(private val postRepository: PostRepository): ViewModel() {

    private val _postList : MutableLiveData<Resource<Test>> = MutableLiveData()
    val postList: LiveData<Resource<Test>> get() = _postList

    init {
        getPosts()
    }

    private fun getPosts()= viewModelScope.launch {
        val posts = postRepository.getPosts()
        _postList.postValue(handlePostResponse(posts))
    }

    private fun handlePostResponse(user: Response<Test>): Resource<Test> {

        if (user.isSuccessful) {
            user.body()?.let { sentUser ->
                return Resource.Success(sentUser)
            }
        }
        return Resource.Error(user.message(),null)
    }
}
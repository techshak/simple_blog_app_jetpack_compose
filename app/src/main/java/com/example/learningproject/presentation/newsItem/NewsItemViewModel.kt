package com.example.learningproject.presentation.newsItem

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningproject.data.remote.dto.PostInfoDto
import com.example.learningproject.repository.PostRepository
import com.example.learningproject.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsItemViewModel @Inject constructor(
    private val postRepository: PostRepository
    ): ViewModel() {

    private var _loginResponse: MutableLiveData<Resource<List<PostInfoDto>>> = MutableLiveData()
    val loginResponse: LiveData<Resource<List<PostInfoDto>>> get() = _loginResponse

    var postListResponse:MutableList<PostInfoDto> = mutableListOf()
    var isLoading = false

    init {
        getPosts()
    }

    private fun getPosts()=
        viewModelScope.launch {

            isLoading = true

            isLoading = try {
                val posts = postRepository.getPosts()
                posts.data?.forEach {
                    postListResponse.add(it)
                }
                false
            } catch (e:Error){
                Resource.Error( "Something went wrong", null)
                false
            }
    }

}
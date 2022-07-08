package com.example.learningproject.presentation.newsItem

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningproject.data.remote.dto.PostInfoDto
import com.example.learningproject.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsItemViewModel @Inject constructor(
    private val postRepository: PostRepository
    ): ViewModel() {

    var postListResponse:List<PostInfoDto> by mutableStateOf(listOf())
    var isLoading = false

    init {
        getPosts()
    }

    private fun getPosts()=
        viewModelScope.launch {
            isLoading = true
            try {
                val posts = postRepository.getPosts()
                postListResponse=posts
                isLoading = false
            }
            catch (e:Error){
                isLoading = false
            }
    }

}
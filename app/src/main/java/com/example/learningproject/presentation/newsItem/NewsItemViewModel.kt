package com.example.learningproject.presentation.newsItem

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.setValue
import com.example.learningproject.repository.post.PostRepository
import com.example.learningproject.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsItemViewModel @Inject constructor(
    private val postRepository: PostRepository
): ViewModel() {
    var state by mutableStateOf(NewsListState())

    init {
        getPosts()
    }

    private fun getPosts()=
        viewModelScope.launch {
           postRepository.getPosts()
               .collect{result->
                   when(result){
                       is Resource.Success -> {
                           result.data?.let { posts->
                               state=state.copy(
                                   postList = posts
                               )
                           }
                       }
                       is Resource.Error -> Unit
                       is Resource.Loading -> {
                           state = state.copy(isLoading = result.isLoading)
                       }
                   }
               }
        }

}
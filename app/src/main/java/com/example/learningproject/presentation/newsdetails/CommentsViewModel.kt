package com.example.learningproject.presentation.newsdetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningproject.presentation.newsItem.NewsListState
import com.example.learningproject.repository.comment.CommentRepository
import com.example.learningproject.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommentsViewModel @Inject constructor(
    private val commentRepository: CommentRepository
): ViewModel() {

    var commentState by mutableStateOf(CommentListState())

     fun getComments (id:Int) =
        viewModelScope.launch {
            commentRepository.getComments(id)
                .collect{result->
                    when(result){
                        is Resource.Success -> {
                            result.data?.let { comments->
                                commentState=commentState.copy(
                                    commentList = comments
                                )
                            }
                        }
                        is Resource.Error -> Unit
                        is Resource.Loading -> {
                            commentState = commentState.copy(
                                isLoading = result.isLoading
                            )
                        }
                    }
                }
        }

}
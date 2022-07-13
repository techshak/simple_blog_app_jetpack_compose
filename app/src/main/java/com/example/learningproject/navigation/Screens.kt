package com.example.learningproject.navigation


sealed class Screens (val route:String){
    object PostsScreen :Screens("posts_screen")
    object DetailsScreen :Screens("details_screen")
}
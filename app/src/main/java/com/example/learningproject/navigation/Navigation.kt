package com.example.learningproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learningproject.presentation.newsdetails.NewsDetailsScreen
import com.example.learningproject.presentation.newsItem.NewsListScreen

@Composable
fun Navigation () {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.PostsScreen.route){
        composable(
            route = Screens.PostsScreen.route,

        ){
            NewsListScreen(navController = navController)
        }
        composable(
            route = Screens.DetailsScreen.route,
        ){
            NewsDetailsScreen()

        }
    }
}
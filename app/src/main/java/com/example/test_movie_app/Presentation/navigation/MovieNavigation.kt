package com.example.test_movie_app.Presentation.viewModels.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.test_movie_app.Presentation.viewModels.screens.ShowsListScreen

@Composable
fun MovieNavigation(navHostController:NavHostController){
    NavHost(navController = navHostController, startDestination = "shows_list" ){
        composable("shows_list"){
            ShowsListScreen(navHostController = navHostController)
        }
    }

}
package com.example.noteapp_cleanarchitect_mvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.noteapp_cleanarchitect_mvvm.presentation.components.MainScreen

@Composable
fun NavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screens.Main.route
        ){
       composable(
           route=Screens.Main.route
       ){
            MainScreen(navController = navController)
       }
    }
}
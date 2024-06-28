package com.example.noteapp_cleanarchitect_mvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.noteapp_cleanarchitect_mvvm.presentation.screens.AddScreen
import com.example.noteapp_cleanarchitect_mvvm.presentation.screens.DetailScreen
import com.example.noteapp_cleanarchitect_mvvm.presentation.screens.MainScreen
import com.example.noteapp_cleanarchitect_mvvm.util.Constans

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
        
        composable(
            route=Screens.AddNote.route
        ){
            AddScreen(navController = navController)
        }
        composable(
            route=Screens.Detail.route,
            arguments = listOf(
                navArgument(
                    name=Constans.DETAIL_ARGUMENT_NOTE_ID
                ) {
                    type = NavType.IntType
                    defaultValue=1
                }
            )
        ){

           DetailScreen(
               navController = navController,
               noteId= it.arguments!!.getInt(Constans.DETAIL_ARGUMENT_NOTE_ID)
           )
        }
        
    }
}
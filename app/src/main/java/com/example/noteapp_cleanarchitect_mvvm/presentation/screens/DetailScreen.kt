package com.example.noteapp_cleanarchitect_mvvm.presentation.screens

import android.util.Log
import androidx.compose.runtime.Composable

import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun DetailScreen(
    navController: NavHostController,
    noteId:Int
){
   Log.d("MyTag", noteId.toString())
}
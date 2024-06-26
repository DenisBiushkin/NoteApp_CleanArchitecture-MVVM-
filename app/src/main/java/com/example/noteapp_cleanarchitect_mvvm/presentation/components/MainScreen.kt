package com.example.noteapp_cleanarchitect_mvvm.presentation.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import com.example.noteapp_cleanarchitect_mvvm.presentation.viewmodels.ToDoListViewModel
import java.time.LocalDateTime


val note =   Note(
    name = "Working",
    description = "Сделать задание по практике, сделать много многа ",
    date_start= LocalDateTime.of(2024, 6, 26,9,0),
    date_finish = LocalDateTime.of(2024, 6, 26,10,0)
)
@Composable
fun MainScreen(
    viewmodel:ToDoListViewModel= hiltViewModel(),
    navController: NavHostController
){
  LazyColumn(){
      items(5){
          ListItem(note)
      }
  }
}
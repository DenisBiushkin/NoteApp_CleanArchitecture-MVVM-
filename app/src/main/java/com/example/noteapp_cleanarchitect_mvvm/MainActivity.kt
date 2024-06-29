package com.example.noteapp_cleanarchitect_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.noteapp_cleanarchitect_mvvm.navigation.NavGraph
import com.example.noteapp_cleanarchitect_mvvm.presentation.ui.theme.NoteApp_CleanArchitect_MVVMTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteApp_CleanArchitect_MVVMTheme {
                NavGraph(navController = rememberNavController())
            }
        }
    }
}

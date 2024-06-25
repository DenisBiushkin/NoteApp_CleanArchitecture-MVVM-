package com.example.noteapp_cleanarchitect_mvvm

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteapp_cleanarchitect_mvvm.presentation.viewmodels.ToDoListViewModel
import com.example.noteapp_cleanarchitect_mvvm.ui.theme.NoteApp_CleanArchitect_MVVMTheme
import dagger.hilt.android.AndroidEntryPoint
import java.sql.Date
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")
            val dateTimeString = "05.09.1974 11:00:00"

            val localDateTime = LocalDateTime.parse(dateTimeString, formatter)

            val zonedDateTime = localDateTime.atZone(ZoneId.of("UTC+3")) // Укажите часовой пояс UTC


            val instant = zonedDateTime.toInstant()

            val timestamp = instant.epochSecond // Получение timestamp в секундах

            NoteApp_CleanArchitect_MVVMTheme {
                val viewmodel:ToDoListViewModel = hiltViewModel()
                Log.d("MyTag","Timestamp: $instant")
            }
        }
    }
}

package com.example.noteapp_cleanarchitect_mvvm.presentation.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import com.example.noteapp_cleanarchitect_mvvm.presentation.viewmodels.ToDoListViewModel
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.iconTitle
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.Calendar


val note =   Note(
    name = "Working",
    description = "Сделать задание по практике, сделать много многа ",
    date_start= LocalDateTime.of(2024, 6, 26,9,0),
    date_finish = LocalDateTime.of(2024, 6, 26,10,0)
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewmodel:ToDoListViewModel= hiltViewModel(),
    navController: NavHostController
){
    val state = viewmodel.state.collectAsState()
    println(state.value.notes)
    var dateDialogController by  remember { mutableStateOf(false) }


    val localDate by remember {
        mutableStateOf(LocalDate.now())
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = {
                dateDialogController=true
            }
        ) {

        }
        if(dateDialogController){
            TestDatePicker(
                confirmButt = {
                    Log.d("MyTag","кнопка нажата")
                    dateDialogController=false

            },
                dismissButt = {
                    dateDialogController=false
                    Log.d("MyTag","кнопка нажата")
                }
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
        ) {
            items(state.value.notes){
                ListItem(note = it)
            }

        }
    }


}

@Preview(showBackground = true)
@Composable
fun showMainScreen(){
    MainScreen(navController = rememberNavController())
}
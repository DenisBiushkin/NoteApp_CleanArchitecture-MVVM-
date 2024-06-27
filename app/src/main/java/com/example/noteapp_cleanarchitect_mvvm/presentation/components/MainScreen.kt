package com.example.noteapp_cleanarchitect_mvvm.presentation.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import com.example.noteapp_cleanarchitect_mvvm.presentation.model.CurrentDay
import com.example.noteapp_cleanarchitect_mvvm.presentation.viewmodels.ToDoListViewModel
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.iconTitle
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.Calendar




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewmodel:ToDoListViewModel= hiltViewModel(),
    navController: NavHostController
){
    val state = viewmodel.state.collectAsState()

    var dateDialogController by  remember { mutableStateOf(false) }
    val selectedDate  by remember {
        mutableStateOf(LocalDate.now())
    }
    Column (
        modifier=Modifier
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.91f)
                //.background(Color.Red)
        ) {

            Button(
                onClick = { dateDialogController=true }
            ) {
            }

            if(dateDialogController){
                TestDatePicker(
                    confirmButt = {
                        viewmodel.onDateSelected(it)
                        dateDialogController=false
                    },
                    dismissButt = { dateDialogController=false }
                )
            }
            BoxItems(
                listNotes = viewmodel.state.value.notes,
                onClickDetailItem = {
                    Log.d("MyTag","Подробная информация о записи")
                },
                onClickDeleteItem= {
                    Log.d("MyTag","Запись удалена")
                },
                currentDate =state.value.currentDay_format,
            )
        }
        Box (
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 5.dp)
            ,
            contentAlignment = Alignment.Center
        ){
            ExtendedFloatingActionButton(
                icon = { Icon(Icons.Filled.Add, contentDescription = "Добавить") },
                text = { Text("Добавить") },
                onClick = {

                }
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun showMainScreen(){
    MainScreen(navController = rememberNavController())
}
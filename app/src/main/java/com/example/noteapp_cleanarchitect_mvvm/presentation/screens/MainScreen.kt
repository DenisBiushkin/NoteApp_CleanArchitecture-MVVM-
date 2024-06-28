package com.example.noteapp_cleanarchitect_mvvm.presentation.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.noteapp_cleanarchitect_mvvm.navigation.Screens
import com.example.noteapp_cleanarchitect_mvvm.presentation.components.BoxItems
import com.example.noteapp_cleanarchitect_mvvm.presentation.components.TestDatePicker
import com.example.noteapp_cleanarchitect_mvvm.presentation.ui.theme.baseUiColor
import com.example.noteapp_cleanarchitect_mvvm.presentation.util.CustomButton
import com.example.noteapp_cleanarchitect_mvvm.presentation.viewmodels.ToDoListViewModel
import java.time.LocalDate


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
        modifier= Modifier
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.91f)
            //.background(Color.Red)
        ) {


            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(0.08f)
                    .background(
                        color = baseUiColor,
                        shape = RoundedCornerShape(7.dp)
                    )
            ){
                Row (
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxSize()
                    ,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    CustomButton(
                        modifier = Modifier
                            .width(100.dp)
                            .height(40.dp)
                            .background(
                                color = Color(0xFF800080),
                                shape = RoundedCornerShape(12.dp)
                            )
                        , text = "Дата",
                        onClick = {
                            dateDialogController=true
                        }
                    )
                }

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
                   // Log.d("MyTag","Подробная информация о записи")
                    navController.navigate(route = Screens.Detail.noteId(12))
                },
                onClickDeleteItem= {
                    //Log.d("MyTag","Запись удалена")
                },
                currentDate =state.value.currentDay_format,

            )
        }
        //часть с добавлением (кнопка добавить)
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
                    navController.navigate(route = Screens.AddNote.route)
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
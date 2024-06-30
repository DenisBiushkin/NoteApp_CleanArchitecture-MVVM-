package com.example.noteapp_cleanarchitect_mvvm.presentation.toDoNote_feature

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
import com.example.noteapp_cleanarchitect_mvvm.presentation.model.CurrentDay
import com.example.noteapp_cleanarchitect_mvvm.presentation.toDoNote_feature.components.BoxItems
import com.example.noteapp_cleanarchitect_mvvm.presentation.util.components.TestDatePicker
import com.example.noteapp_cleanarchitect_mvvm.presentation.ui.theme.baseUiColor
import com.example.noteapp_cleanarchitect_mvvm.presentation.toDoNote_feature.components.CustomButton
import com.example.noteapp_cleanarchitect_mvvm.presentation.toDoNote_feature.util.NoteMainEvent
import com.example.noteapp_cleanarchitect_mvvm.presentation.util.ChoiceTypeDatePicker
import java.time.LocalDate


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewmodel: ToDoListViewModel = hiltViewModel(),
    navController: NavHostController
){

    val state = viewmodel.state.collectAsState()
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
            TopPart(
                onClickDate = {
                    viewmodel.onEvent(
                        NoteMainEvent.ChangeDatePickerState(
                            ChoiceTypeDatePicker.SelectedPicker
                        )
                    )
                }
            )
            if(state.value.dateWindowVisibility){
                TestDatePicker(
                    confirmButt = {
                        viewmodel.onEvent(
                            NoteMainEvent.ChangeDatePickerState(
                                ChoiceTypeDatePicker.AcceptedDate(it.atTime(0,0))
                            )
                        )
                    },
                    dismissButt = {
                        viewmodel.onEvent(
                            NoteMainEvent.ChangeDatePickerState(
                                ChoiceTypeDatePicker.RefusedDate
                            )
                        )
                    }
                )
            }
            BoxItems(
                listNotes = state.value.notes,
                onClickDetailItem = {
                    navController.navigate(route = Screens.Detail.toJsonFromNote(it))
                },
                onClickDeleteItem= {
                    viewmodel.onEvent(
                        NoteMainEvent.DeleteNote(it)
                    )
                },
                currentDate = state.value.currentDay_format
            )
        }
        Box (
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 5.dp),
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
@Composable
fun TopPart(
    onClickDate:()->Unit,
    colorBackground:Color= baseUiColor,
){
    Box(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .fillMaxHeight(0.08f)
            .background(
                color = colorBackground,
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
                    onClickDate()
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
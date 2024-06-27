package com.example.noteapp_cleanarchitect_mvvm.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import com.example.noteapp_cleanarchitect_mvvm.presentation.model.CurrentDay
import java.time.LocalDateTime

val note = Note(
    name = "Working",
    description = "Сделать задание по практике, сделать много многа ",
    date_start= LocalDateTime.of(2024, 6, 26,9,0),
    date_finish = LocalDateTime.of(2024, 6, 26,10,0)
).toNoteUI()
@Composable
fun MainScreenFull_TEST(){
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

            Button(
                onClick = {
                //dateDialogController=true
                }
            ) {

            }

//            if(dateDialogController){
//                TestDatePicker(
//                    confirmButt = {
//                        viewmodel.onDateSelected(it)
//                        dateDialogController=false
//                    },
//                    dismissButt = { dateDialogController=false }
//                )
//            }
            BoxItems(
                //listNotes = viewmodel.state.value.notes,
                listNotes = listOf(
                    note,note,note,note,
                    note,note,note,note,
                    note,note,note,note,
                ),
                onClickDetailItem = {
                    Log.d("MyTag","Подробная информация о записи")
                },
                onClickDeleteItem= {
                    Log.d("MyTag","Запись удалена")
                },
                //currentDate =state.value.currentDay_format,
                currentDate = CurrentDay()
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
fun showMainScreenFull_TEST(){
        MainScreenFull_TEST()
}
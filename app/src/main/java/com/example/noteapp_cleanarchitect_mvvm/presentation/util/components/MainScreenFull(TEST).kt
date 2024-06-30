package com.example.noteapp_cleanarchitect_mvvm.presentation.util.components

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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapp_cleanarchitect_mvvm.presentation.model.CurrentDay
import com.example.noteapp_cleanarchitect_mvvm.util.Constans

val note =Constans.testnote
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


            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(0.08f)
                    .background(
                        color = Color(0xFFea8df7),
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

                        }
                    )
                }

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
                    note, note, note, note,
                    note, note, note, note,

                ),
                onClickDetailItem = {
                    Log.d("MyTag","Подробная информация о записи")
                },
                onClickDeleteItem= {
                    Log.d("MyTag","Запись удалена")
                },
                //currentDate =state.value.currentDay_format,
                currentDate = CurrentDay(
                    date_format = "27.06.2024",
                    dayweek = "четверг"
                )
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
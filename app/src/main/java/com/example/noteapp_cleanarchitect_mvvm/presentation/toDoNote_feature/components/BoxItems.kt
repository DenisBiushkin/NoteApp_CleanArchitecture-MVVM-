package com.example.noteapp_cleanarchitect_mvvm.presentation.toDoNote_feature.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import com.example.noteapp_cleanarchitect_mvvm.presentation.model.CurrentDay
import com.example.noteapp_cleanarchitect_mvvm.presentation.model.NoteUI
import com.example.noteapp_cleanarchitect_mvvm.presentation.ui.theme.baseUiColor
import com.example.noteapp_cleanarchitect_mvvm.util.Constans
import java.time.LocalDateTime

@Composable
fun BoxItems(
    listNotes: List<NoteUI>,
    onClickDeleteItem:(NoteUI)->Unit,
    onClickDetailItem:(NoteUI)->Unit,
    currentDate: CurrentDay
){
    val shapebox = RoundedCornerShape(15.dp)


   // Log.d("MyTag","${currentDate.value.date_format} Здесь")
    Box(modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth()
        .background(
            shape = shapebox,
            brush = Brush.verticalGradient(
                colors = listOf(baseUiColor, Color.Transparent)
            )
        )
        .border(
            width = 1.dp,
            color =baseUiColor,
            shape = shapebox
        )
    ){
        Column(
        ) {
            Row(
                modifier = Modifier
                    .padding(start = 10.dp, top = 5.dp, end = 10.dp)
                    .fillMaxWidth()
                    .height(30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text= buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontSize = 20.sp,
                                fontFamily = Constans.fontFamily,
                                fontWeight = FontWeight.Normal
                            )
                        ){
                            append("${currentDate.date_format} г")
                        }
                    }
                )
                Text(
                    text= buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontSize = 20.sp,
                                fontFamily = Constans.fontFamily,
                                fontWeight = FontWeight.Normal
                            )
                        ){
                            append(currentDate.dayweek)
                        }
                    }
                )
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(listNotes){
                    ListItem(note =it,
                        onClickDelit = {
                            onClickDeleteItem(it)
                        },
                        onClickItem = {
                            onClickDetailItem(it)
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun showBoxItems(){

    val note = Note(
        name = "Working",
        description = "Сделать задание по практике, сделать много многа ",
        date_start= LocalDateTime.of(2024, 6, 26,9,0),
        date_finish = LocalDateTime.of(2024, 6, 26,10,0),
        color = 12
    ).toNoteUI()
    BoxItems(

        listNotes = listOf(
            note,note,
            note,note,
            note,note,
            note,note,

        ),
        onClickDeleteItem = {

        },
        onClickDetailItem = {

        },
        currentDate =CurrentDay(date_format = "27.0.2024")
    )
}
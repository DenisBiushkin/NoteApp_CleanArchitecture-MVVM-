package com.example.noteapp_cleanarchitect_mvvm.presentation.toDoNote_feature.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapp_cleanarchitect_mvvm.R
import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import com.example.noteapp_cleanarchitect_mvvm.presentation.model.NoteUI
import com.example.noteapp_cleanarchitect_mvvm.util.Constans
import java.time.LocalDateTime


@Composable
fun ListItem(
    note: NoteUI,
    onClickItem: () -> Unit,
    onClickDelit: () -> Unit
){

    val gradient =Brush.horizontalGradient(
        colors = listOf(
            Color.Cyan,
            Color.Transparent),
        endX =700.0f
    )
    Card(
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 6.dp)
            .fillMaxWidth()
            .height(70.dp)
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = gradient)
                .clickable {
                    onClickItem()
                }
        ){
            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                PeriodTime(
                    modifier = Modifier
                        .fillMaxWidth(0.22f)
                    ,
                    note = note
                )
                TextItem(
                    modifier = Modifier
                        .fillMaxWidth(0.90f)
                    //0.85f для икноки удаления
                    ,
                    note = note
                )


//                Box (
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .fillMaxHeight()
//                    ,contentAlignment = Alignment.Center
//                ){
//                    Icon(
//                        modifier = Modifier
//                            .size(30.dp)
//                            .clickable {
//                              onClickDelit()
//                        },
//                        painter = painterResource(
//                            id = R.drawable.baseline_delete),
//                        contentDescription = "")
//                }


            }
        }
    }
}
@Composable
fun TextItem(
    modifier: Modifier =Modifier,
    note: NoteUI
){
    Column(
        modifier = modifier
            .padding(top =5.dp)
        // .background(Color.Cyan)//TEST
        , verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
             contentAlignment = Alignment.Center
        ){
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            textDecoration = TextDecoration.Underline,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        )){
                        append(note.name)
                    }
                }
            )
        }
        Text(
            modifier = Modifier
                .padding(horizontal=5.dp)
            ,
            text = note.description,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
@Composable
fun PeriodTime(
    modifier: Modifier=Modifier,
    note: NoteUI
){
    Column (
        modifier = modifier
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val style=TextStyle(
            fontSize = 22.sp,
            color=Color.Black,
            fontFamily = Constans.fontFamily,
            fontWeight = FontWeight.Medium
        )
        Text(text = note.time_start, style = style)
        Text(text = note.time_finish,style=style)
    }

}
@Preview(showBackground = true)
@Composable
fun showListItem(){
    ListItem(note = Note(
            name = "Working",
            description = "Сделать задание по практике, сделать много многа ",
            date_start= LocalDateTime.of(2024, 6, 26,9,0),
            date_finish = LocalDateTime.of(2024, 6, 26,10,0),
            color = 12
    ).toNoteUI(),
        onClickDelit = {

        },
        onClickItem = {

        }
    )
}

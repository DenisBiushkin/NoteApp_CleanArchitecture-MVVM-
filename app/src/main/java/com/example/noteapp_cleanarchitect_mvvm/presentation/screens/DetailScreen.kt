package com.example.noteapp_cleanarchitect_mvvm.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.noteapp_cleanarchitect_mvvm.R
import com.example.noteapp_cleanarchitect_mvvm.navigation.Screens
import com.example.noteapp_cleanarchitect_mvvm.presentation.ui.theme.baseUiColor
import com.example.noteapp_cleanarchitect_mvvm.presentation.ui.theme.detailUiColor
import com.example.noteapp_cleanarchitect_mvvm.presentation.viewmodels.DetailScreenViewModel
import com.example.noteapp_cleanarchitect_mvvm.util.Constans

@Composable
fun DetailScreen(
    viewModel: DetailScreenViewModel = hiltViewModel(),
    navController: NavHostController,
    noteId:Int,
){
    val gradient= Brush.linearGradient(
        colors = listOf(
            detailUiColor,
            Color.Transparent
        )
    )

    val currentNote=Constans.testnote
   Box(
        modifier = Modifier
            .background(
                brush = gradient
            )
            .padding(start = 20.dp, end = 20.dp, top = 30.dp, bottom = 20.dp)
            .fillMaxSize()

   ){
       Column(
           modifier= Modifier
               .fillMaxSize()
              // .background(Color.Blue)
       ) {

           Row (
               modifier= Modifier
                   .fillMaxWidth(),
               horizontalArrangement = Arrangement.SpaceBetween,
               verticalAlignment = Alignment.CenterVertically
           ){
               Text(
                   text = buildAnnotatedString {
                       withStyle(
                           style = SpanStyle(
                               fontSize = 35.sp,
                               fontFamily = Constans.fontFamily
                           )
                       ){
                           append(currentNote.name)
                       }
                   }
               )
               Icon(
                   modifier = Modifier
                       .size(33.dp).clickable {
                          navController.navigate(Screens.Main.route)
                       }

                   ,painter = painterResource(
                       id = R.drawable.baseline_arrow_back_24),
                   contentDescription =""
               )
           }
           Spacer(modifier = Modifier.height(20.dp))
           BlockInfoSpan(
               title="Дата выполнения задачи",
               time="28.06.2024, сегодня",
               icon= painterResource(
                   id = R.drawable.baseline_calendar_today_24
               )
           )
           Spacer(modifier = Modifier.height(12.dp))
           BlockInfoSpan(
               title="Время выполнения задачи",
               time="11:00 - 14:00",
               icon= painterResource(
                   id = R.drawable.baseline_access_time_24
               )
           )
           Spacer(modifier = Modifier.height(12.dp))
           BlockInfoSpan(
               title = currentNote.description,
               time ="" ,
               icon = painterResource(id = R.drawable.baseline_insert_drive_file_24)
           )


       }
   }
}

@Composable
fun BlockInfoSpan(
    title:String,
    time:String,
    icon:Painter,
    showSecondPart:Boolean=true
){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ){
        Icon(
            modifier = Modifier
                .padding(top=5.dp)
            , painter = icon,
            contentDescription = "",
            tint = Color(0xFFffba42),
            //tint=baseUiColor
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = buildAnnotatedString {
                withStyle(
                    style= SpanStyle(
                        fontFamily = Constans.fontFamily,
                        fontSize = 22.sp
                    )
                ){
                    append(title)
                }
            }
            )
            if(showSecondPart){
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = buildAnnotatedString {
                    withStyle(
                        style= SpanStyle(
                            fontFamily = Constans.fontFamily,
                            fontSize = 19.sp,
                            color=Color(0xFFb0a9ab)
                        )
                    ){
                        append(time)
                    }
                }
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun showMainScreenFull_TEST(){
    DetailScreen(
        navController = rememberNavController(),
        noteId = 5
    )
}
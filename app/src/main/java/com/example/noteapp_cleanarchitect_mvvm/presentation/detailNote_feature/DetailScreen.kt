package com.example.noteapp_cleanarchitect_mvvm.presentation.detailNote_feature

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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavHostController
import com.example.noteapp_cleanarchitect_mvvm.R
import com.example.noteapp_cleanarchitect_mvvm.navigation.Screens
import com.example.noteapp_cleanarchitect_mvvm.presentation.model.NoteUI
import com.example.noteapp_cleanarchitect_mvvm.presentation.ui.theme.detailUiColor
import com.example.noteapp_cleanarchitect_mvvm.util.Constans

@Composable
fun DetailScreen(
    viewModel: DetailScreenViewModel = hiltViewModel(),
    navController: NavHostController,
    note: NoteUI,
){

    val state = viewModel.state.collectAsState()

    val noteUi by remember {
        mutableStateOf(note)
    }
    val gradient= Brush.linearGradient(
        colors = listOf(
            detailUiColor,
            Color.Transparent
        )
    )
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
                               append(noteUi.name)
                           }
                       }
                   )
                   Icon(
                       modifier = Modifier
                           .size(33.dp)
                           .clickable {
                               navController.navigate(Screens.Main.route)
                           }

                       ,painter = painterResource(
                           id = R.drawable.baseline_arrow_back_24),
                       contentDescription =""
                   )
               }
               val date_format =state.value.currentDay_format
               Spacer(modifier = Modifier.height(20.dp))
               BlockInfoSpan(
                   title="Дата выполнения задачи",
                   time="${noteUi.date}  ${noteUi.currentDate_week}",
                   icon= painterResource(
                       id = R.drawable.baseline_calendar_today_24
                   )
               )
               Spacer(modifier = Modifier.height(12.dp))
               BlockInfoSpan(
                   title="Время выполнения задачи",
                   time="${noteUi.time_start} - ${noteUi.time_finish}",
                   icon= painterResource(
                       id = R.drawable.baseline_access_time_24
                   )
               )
               Spacer(modifier = Modifier.height(12.dp))
               BlockInfoSpan(
                   title = noteUi.description,
                   time ="" ,
                   icon = painterResource(id = R.drawable.baseline_insert_drive_file_24)
               )


           }
       }

}

@Preview(showBackground = true)
@Composable
fun showMainScreenFull_TEST(){
//    DetailScreen(
//        navController = rememberNavController(),
//        note = Constans.testnote
//    )
}
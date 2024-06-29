package com.example.noteapp_cleanarchitect_mvvm.presentation.addNote_feature

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
import androidx.compose.material.Text
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.noteapp_cleanarchitect_mvvm.R
import com.example.noteapp_cleanarchitect_mvvm.navigation.Screens
import com.example.noteapp_cleanarchitect_mvvm.presentation.addNote_feature.components.DateFieldWithIcon
import com.example.noteapp_cleanarchitect_mvvm.presentation.addNote_feature.components.TextFieldWithIcon
import com.example.noteapp_cleanarchitect_mvvm.presentation.addNote_feature.components.TransparentTextField
import com.example.noteapp_cleanarchitect_mvvm.presentation.ui.theme.detailUiColor
import com.example.noteapp_cleanarchitect_mvvm.presentation.util.components.ExprimentalTimeDialogPicker
import com.example.noteapp_cleanarchitect_mvvm.presentation.util.components.TestDatePicker
import com.example.noteapp_cleanarchitect_mvvm.util.Constans
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(
    //viewModel: AddScreenViewModel= hiltViewModel(),
    navController: NavHostController
){

    val startColor=detailUiColor
    val gradient= Brush.linearGradient(
        colors = listOf(
            startColor,
            androidx.compose.ui.graphics.Color.Transparent
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
     Column (
      modifier = Modifier.fillMaxSize()
     ){
         Row (
             modifier= Modifier
                 .fillMaxWidth(),
             horizontalArrangement = Arrangement.SpaceBetween,
             verticalAlignment = Alignment.CenterVertically
         ){
             TransparentTextField(
                 text ="" ,
                 onTextChange = {

                 },
                 hint = "Заголовок",
                 hintStyle = TextStyle(
                     fontSize = 35.sp,
                     fontFamily = Constans.fontFamily,
                     color = Color.Black.copy(alpha = 0.5f)
                 ),
                 textStyle = TextStyle(
                     fontSize = 35.sp,
                     fontFamily = Constans.fontFamily,
                 ),
                 color =startColor,
                 hintVisibility = true,
                 focused = {
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
         Spacer(modifier = Modifier.height(20.dp))
         val date_text = remember {
             mutableStateOf("")
         }
         val hintVisibility =remember {
             mutableStateOf(true)
         }
         val gialogController= remember {
             mutableStateOf(false)
         }
         DateFieldWithIcon(
             icon = painterResource(id =R.drawable.baseline_edit_calendar_24),
             tintColor =  Color(0xFFffba42),
             date_text = date_text.value,
             hint="Дата",
             hintVisibility =hintVisibility.value,
             dateDialogController=gialogController.value,
             date_textStyle = TextStyle(
                 fontSize = 22.sp,
                 fontFamily = Constans.fontFamily
             ),
             hintStyle = TextStyle(
                 fontSize = 22.sp,
                 fontFamily = Constans.fontFamily,
                 color = Color.Black.copy(alpha = 0.5f)
             ),
             ondateConfirm = {
                 println(it.toLocalDate())
                 gialogController.value=!gialogController.value
             },
             ondateRefused = {
                 gialogController.value=!gialogController.value
             },
             onClickDateBut = {
                 gialogController.value=!gialogController.value
             },
             selector = ClockSelector.Date
         )

         val time_text = remember {
             mutableStateOf("")
         }
         val  hintTimeVisibility=remember {
             mutableStateOf(true)
         }
         val timedialogController= remember {
             mutableStateOf(false)
         }
         Spacer(modifier = Modifier.height(12.dp))
         DateFieldWithIcon(
             icon = painterResource(id =R.drawable.baseline_access_time_24),
             tintColor =  Color(0xFFffba42),
             date_text = time_text.value,
             hint="Время начала дела",
             hintVisibility =hintTimeVisibility.value,
             dateDialogController=timedialogController.value,
             date_textStyle = TextStyle(
                 fontSize = 22.sp,
                 fontFamily = Constans.fontFamily
             ),
             hintStyle = TextStyle(
                 fontSize = 22.sp,
                 fontFamily = Constans.fontFamily,
                 color = Color.Black.copy(alpha = 0.5f)
             ),
             ondateConfirm = {
                 println(it.toLocalTime())
                 timedialogController.value=!timedialogController.value
             },
             ondateRefused = {
                 timedialogController.value=!timedialogController.value
             },
             onClickDateBut = {
                 timedialogController.value=!timedialogController.value
             },
             selector = ClockSelector.Time
         )
         Spacer(modifier = Modifier.height(12.dp))
         DateFieldWithIcon(
             icon = painterResource(id =R.drawable.baseline_access_time_24),
             tintColor =  Color(0xFFffba42),
             date_text = time_text.value,
             hint="Время конца дела",
             hintVisibility =hintTimeVisibility.value,
             dateDialogController=timedialogController.value,
             date_textStyle = TextStyle(
                 fontSize = 22.sp,
                 fontFamily = Constans.fontFamily
             ),
             hintStyle = TextStyle(
                 fontSize = 22.sp,
                 fontFamily = Constans.fontFamily,
                 color = Color.Black.copy(alpha = 0.5f)
             ),
             ondateConfirm = {
                 println(it.toLocalTime())
                 timedialogController.value=!timedialogController.value
             },
             ondateRefused = {
                 timedialogController.value=!timedialogController.value
             },
             onClickDateBut = {
                 timedialogController.value=!timedialogController.value
             },
             selector = ClockSelector.Time
         )
         Spacer(modifier = Modifier.height(12.dp))

         val text = remember {
             mutableStateOf("")
         }
         val hintvisibility = remember {
             mutableStateOf(true)
         }
         TextFieldWithIcon(
             icon = painterResource(id = R.drawable.baseline_insert_drive_file_24),
             tintIcon = Color(0xFFffba42),
             text=text.value,
             onTextChanged = {
                  text.value=it
             },
             focused = {
                 hintvisibility.value=!it.isFocused &&
                         text.value.isBlank()
             },
             hintVisibility = hintvisibility.value,
             hint="Описание",
             textStyle = TextStyle(
                 fontSize = 22.sp,
                 fontFamily = Constans.fontFamily
             ),
             hintTextStyle = TextStyle(
                 fontSize = 22.sp,
                 fontFamily = Constans.fontFamily,
                 color = Color.Black.copy(alpha = 0.5f)
             ),
             colorField = Color.Transparent
         )
     }
  }
}


@Preview(showBackground = true)
@Composable
fun showAddScreen(){
    AddScreen(navController = rememberNavController())
}
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.noteapp_cleanarchitect_mvvm.presentation.addNote_feature.util.AddNoteEvent
import com.example.noteapp_cleanarchitect_mvvm.presentation.addNote_feature.util.ClockSelector
import com.example.noteapp_cleanarchitect_mvvm.presentation.ui.theme.detailUiColor
import com.example.noteapp_cleanarchitect_mvvm.presentation.util.ChoiceTypeDatePicker
import com.example.noteapp_cleanarchitect_mvvm.util.Constans

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(
    viewModel: AddScreenViewModel= hiltViewModel(),
    navController: NavHostController
){


    val startColor=detailUiColor
    val gradient= Brush.linearGradient(
        colors = listOf(
            startColor,
            androidx.compose.ui.graphics.Color.Transparent
        )
    )
    val hintStyle:TextStyle =  TextStyle(
        fontSize = 22.sp,
        fontFamily = Constans.fontFamily,
        color = Color.Black.copy(alpha = 0.5f)
    )
    val textStyle:TextStyle=TextStyle(
        fontSize = 22.sp,
        fontFamily = Constans.fontFamily,
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

      ){
          Row (
              modifier= Modifier
                  .fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
          ){

              val title=viewModel.titleText.value
              TransparentTextField(
                  modifierField = Modifier.width(220.dp),
                  text =title.text,
                  onTextChange = { viewModel.onEvent(AddNoteEvent.EnteredTitle(title = it)) },
                  hint = title.hint,
                  hintStyle = hintStyle.copy(fontSize = 35.sp),
                  textStyle = textStyle.copy(fontSize = 35.sp),
                  color =startColor,
                  hintVisibility = title.hintVisibility,
                  focused = { viewModel.onEvent(AddNoteEvent.ChangeTitleVisibility(it)) }
              )
              IconClickeble(
                  onClickIcon = { navController.navigate(Screens.Main.route) },
                  icon=painterResource(id = R.drawable.baseline_arrow_back_24)
              )
          }
          Spacer(modifier = Modifier.height(20.dp))

          val date=viewModel.date_text.value
          DateFieldWithIcon(
              icon = painterResource(id =R.drawable.baseline_edit_calendar_24),
              iconColor =  Color(0xFFffba42),
              date_text = date.date_text,
              hint=date.hint,
              hintVisibility =date.hintVisibility,
              dateDialogController=date.dateWindowVisibility,
              date_textStyle = textStyle,
              hintStyle =hintStyle,
              ondateConfirm = {
                  viewModel.onEvent(
                      AddNoteEvent.ChoiseDate(ChoiceTypeDatePicker.AcceptedDate(it))
                  )
              },
              ondateRefused = {
                  viewModel.onEvent(
                      AddNoteEvent.ChoiseDate(ChoiceTypeDatePicker.RefusedDate)
                  )
              },
              onClickDateBut = {
                  viewModel.onEvent(
                      AddNoteEvent.ChoiseDate(ChoiceTypeDatePicker.SelectedPicker)
                  )
              },
              selector = ClockSelector.Date
          )
          val time_start=viewModel.timeStart_text.value
          Spacer(modifier = Modifier.height(12.dp))
          DateFieldWithIcon(
              icon = painterResource(id =R.drawable.baseline_access_time_24),
              iconColor =  Color(0xFFffba42),
              date_text = time_start.date_text,
              hint="Время начала дела",
              hintVisibility =time_start.hintVisibility,
              dateDialogController=time_start.dateWindowVisibility,
              date_textStyle = textStyle,
              hintStyle = hintStyle,
              ondateConfirm = {
                  viewModel.onEvent(
                      AddNoteEvent.ChoiseStartTime(ChoiceTypeDatePicker.AcceptedDate(it))
                  )
              },
              ondateRefused = {
                  viewModel.onEvent(
                      AddNoteEvent.ChoiseStartTime(ChoiceTypeDatePicker.RefusedDate)
                  )
              },
              onClickDateBut = {
                  viewModel.onEvent(
                      AddNoteEvent.ChoiseStartTime(ChoiceTypeDatePicker.SelectedPicker)
                  )
              },
              selector = ClockSelector.Time
          )
          val time_finish=viewModel.timeFinish_text.value
          Spacer(modifier = Modifier.height(12.dp))
          DateFieldWithIcon(
              icon = painterResource(id =R.drawable.baseline_access_time_24),
              iconColor =  Color(0xFFffba42),
              date_text = time_finish.date_text,
              hint="Время начала дела",
              hintVisibility =time_finish.hintVisibility,
              dateDialogController=time_finish.dateWindowVisibility,
              date_textStyle = textStyle,
              hintStyle = hintStyle,
              ondateConfirm = {
                  viewModel.onEvent(
                      AddNoteEvent.ChoiseFinishTime(ChoiceTypeDatePicker.AcceptedDate(it))
                  )
              },
              ondateRefused = {
                  viewModel.onEvent(
                      AddNoteEvent.ChoiseFinishTime(ChoiceTypeDatePicker.RefusedDate)
                  )
              },
              onClickDateBut = {
                  viewModel.onEvent(
                      AddNoteEvent.ChoiseFinishTime(ChoiceTypeDatePicker.SelectedPicker)
                  )
              },
              selector = ClockSelector.Time
          )
          Spacer(modifier = Modifier.height(12.dp))
          val description = viewModel.descriptinText.value
          TextFieldWithIcon(
              icon = painterResource(id = R.drawable.baseline_insert_drive_file_24),
              tintIcon = Color(0xFFffba42),
              text=description.text,
              onTextChanged = {
                  viewModel.onEvent(AddNoteEvent.EnteredDescription(it))
              },
              focused = {
                  viewModel.onEvent(AddNoteEvent.ChangeDescriptionVisibility(it))
              },
              hintVisibility =description.hintVisibility,
              hint=description.hint,
              textStyle = textStyle,
              hintTextStyle = hintStyle,
              maxTextLines = 10
          )
          Spacer(modifier = Modifier.height(15.dp))
          Box (
              modifier = Modifier
                  .padding(bottom = 15.dp)
                  .fillMaxWidth()
              ,
              contentAlignment = Alignment.Center
          ){
              ExtendedFloatingActionButton(
                  icon = {
                      Icon(Icons.Filled.Check, contentDescription = "")
                  },
                  text = { Text("Принять") },
                  onClick = {
                      viewModel.onEvent(AddNoteEvent.SaveNote)
                      navController.navigate(route = Screens.Main.route)
                  }
              )
          }
      }
  }
}
@Composable
fun IconClickeble(
    onClickIcon:()->Unit,
    icon: Painter
){
    Icon(
        modifier = Modifier
            .size(33.dp)
            .clickable {
                onClickIcon()
            }
        ,painter = icon,
        contentDescription =""
    )
}
@Preview(showBackground = true)
@Composable
fun showAddScreen(){
    AddScreen(navController = rememberNavController())
}
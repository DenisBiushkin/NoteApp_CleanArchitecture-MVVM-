package com.example.noteapp_cleanarchitect_mvvm.presentation.components

import android.util.Log
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZoneOffset
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestDatePicker(
    confirmButt:() -> Unit,
    dismissButt: () -> Unit
){

    val localDate by remember {
        mutableStateOf(LocalDate.now())
    }
    val currentDate = remember {
        Calendar.getInstance().apply {
            set(Calendar.YEAR, localDate.year)
            set(Calendar.MONTH, localDate.monthValue-1)
            set(Calendar.DAY_OF_MONTH, localDate.dayOfMonth)
        }.timeInMillis
    }
    val dateState = rememberDatePickerState(
        initialSelectedDateMillis = currentDate
    )
    Log.d("MyTag",currentDate.toString())
    DatePickerDialog(
        onDismissRequest = {
            Log.d("MyTag","onDismissRequest TestPic")
                           },
        confirmButton = {
            TextButton(onClick = {
                confirmButt()
            }) {
                Text(text = "Принять")
                Log.d("MyTag",currentDate.toString())
            }
        },
        dismissButton = {
            TextButton(onClick = {
                    dismissButt()
            }) {
                Text(text = "Отмена")
            }
        }
    ) {
        DatePicker(state = dateState)
    }

}


//@Preview(showBackground = true)
//@Composable
//fun showTestdatePicker(){
//    TestDatePicker()
//}
package com.example.noteapp_cleanarchitect_mvvm.presentation.util.components

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
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.sql.Timestamp
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZoneOffset
import java.util.Calendar
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestDatePicker(
    confirmButt:(LocalDate) -> Unit,
    dismissButt: () -> Unit,
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
    var selectedDate by remember { mutableLongStateOf(0L) }
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
                if(dateState.selectedDateMillis != null){
                    selectedDate = dateState.selectedDateMillis!!
                }
                confirmButt(convertLongToDate(selectedDate))
                Log.d("MyTag",selectedDate.toString())
            }) {
                Text(text = "Принять")
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
fun convertLongToDate(timeInMillis: Long): LocalDate{
    return Instant.ofEpochMilli(timeInMillis)
        .atZone(ZoneId.systemDefault())
        .toLocalDate()
}


//@Preview(showBackground = true)
//@Composable
//fun showTestdatePicker(){
//    TestDatePicker()
//}
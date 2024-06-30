package com.example.noteapp_cleanarchitect_mvvm.presentation.addNote_feature.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.noteapp_cleanarchitect_mvvm.presentation.addNote_feature.ClockSelector
import com.example.noteapp_cleanarchitect_mvvm.presentation.util.components.ExprimentalTimeDialogPicker
import com.example.noteapp_cleanarchitect_mvvm.presentation.util.components.TestDatePicker
import java.time.LocalDate
import java.time.LocalDateTime

@Composable
fun DateFieldWithIcon(
    icon: Painter,
    iconColor: Color,
    date_text:String,
    date_textStyle: TextStyle,
    ondateConfirm:(LocalDateTime)->Unit,
    ondateRefused:()->Unit,
    onClickDateBut:()->Unit,
    hint:String,
    hintStyle: TextStyle,
    hintVisibility: Boolean=true,
    dateDialogController:Boolean=false,
    selector: ClockSelector = ClockSelector.Time
){
    Row(
        modifier = Modifier.fillMaxWidth()
    ){
        Icon(
            painter = icon,
            contentDescription ="",
            tint = iconColor
        )

        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text =date_text,
            style = date_textStyle,
            modifier = Modifier.clickable {
                onClickDateBut()
            },
        )
        if(hintVisibility){
            Text(
                modifier = Modifier.clickable {
                    onClickDateBut()
                },
                text =hint,
                style = hintStyle
            )
        }
        if(dateDialogController){
            when(selector){
                is ClockSelector.Date ->{
                    TestDatePicker(
                        confirmButt = {
                            ondateConfirm(it.atTime(0,0))
                        },
                        dismissButt = {
                            ondateRefused()
                        }
                    )
                }
                is ClockSelector.Time->{
                    ExprimentalTimeDialogPicker(
                        onDismissRequest = {

                        },
                        confirmButt = {
                            ondateConfirm(LocalDate.of(2024,6,29).atTime(it))
                        },
                        dismissButt = {
                            ondateRefused()
                        }
                    )
                }
            }

        }
    }
}
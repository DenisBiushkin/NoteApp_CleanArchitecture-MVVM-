package com.example.noteapp_cleanarchitect_mvvm.presentation.addNote_feature.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldWithIcon(
    icon: Painter,
    tintIcon: Color,
    text:String,
    textStyle: TextStyle,
    onTextChanged:(String)->Unit,
    hint:String,
    hintTextStyle: TextStyle,
    hintVisibility:Boolean=true,
    focused:(FocusState)->Unit,
    colorField: Color=Color.Transparent
){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ){
        Icon(
            painter = icon,
            contentDescription ="",
            tint = tintIcon
        )
        Spacer(modifier = Modifier.width(10.dp))
        TransparentTextField(
            text =text,
            onTextChange = { onTextChanged(it) },
            hint = hint,
            hintStyle = hintTextStyle,
            textStyle =textStyle,
            color =colorField,
            hintVisibility = hintVisibility,
            focused = {
                focused(it)
            }
        )

    }
}
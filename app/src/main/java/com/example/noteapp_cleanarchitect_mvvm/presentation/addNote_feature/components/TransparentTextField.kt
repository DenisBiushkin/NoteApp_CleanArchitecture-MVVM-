package com.example.noteapp_cleanarchitect_mvvm.presentation.addNote_feature.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle

@Composable
fun TransparentTextField(
    modifierField: Modifier = Modifier,
    text:String,
    onTextChange:(String)->Unit,
    hint:String,
    hintStyle:TextStyle,
    textStyle: TextStyle,
    hintVisibility: Boolean =true,
    focused : (FocusState)->Unit,
    color : Color,
    maxTextLines:Int=1
){
    Box(

    ){

       BasicTextField(

           value =text,
           maxLines= maxTextLines,
           onValueChange ={
              onTextChange(it)
           } ,
           modifier = modifierField
               .background(
               color=color)
               .onFocusChanged {
                    focused(it)
               }
           ,
           textStyle = textStyle
       )

        if(hintVisibility){
            Text(
                text =hint,
                style = hintStyle
            )
        }
    }
}
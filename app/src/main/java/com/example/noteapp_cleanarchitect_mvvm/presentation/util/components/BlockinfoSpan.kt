package com.example.noteapp_cleanarchitect_mvvm.presentation.util.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapp_cleanarchitect_mvvm.util.Constans

@Composable
fun BlockInfoSpan(
    title:String,
    time:String,
    icon: Painter,
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
                            color= Color(0xFFb0a9ab)
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
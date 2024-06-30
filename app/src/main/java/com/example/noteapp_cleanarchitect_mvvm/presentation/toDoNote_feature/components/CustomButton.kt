package com.example.noteapp_cleanarchitect_mvvm.presentation.toDoNote_feature.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapp_cleanarchitect_mvvm.R

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text:String="Button",
    color: Color =Color(0xFF800080),
    colorText: Color =Color(0xFFfdfff5),
    onClick: ()->Unit
){
    Box(
        modifier= modifier
            .defaultMinSize(minHeight = 45.dp, minWidth = 120.dp)
            .background(
                color = color,
                shape = RoundedCornerShape(17.dp)
            ).clickable {
                        onClick()
            }
        ,
        contentAlignment = Alignment.Center
    ){
        Row (
            modifier=modifier.padding(6.dp)
            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal,
                            color=colorText
                        )
                    ){
                        append(text)
                    }
                }
            )
            //Spacer(modifier = Modifier.width(7.dp))
            Icon(
                modifier= Modifier.size(25.dp),
                painter = painterResource(id = R.drawable.baseline_edit_calendar_24)
                , contentDescription = "",
                tint =colorText
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun showCustomButton(){
    CustomButton(
        onClick = {

        }
    )
}
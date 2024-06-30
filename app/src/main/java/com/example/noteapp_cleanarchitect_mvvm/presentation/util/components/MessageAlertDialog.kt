package com.example.noteapp_cleanarchitect_mvvm.presentation.util.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MessageAlertDialog(
    message:String,
    title:String,
    acceptButton:()->Unit,
    dialogContorller:Boolean=false
){
    if (dialogContorller) {
        AlertDialog(
            onDismissRequest = {  },
            title = {
                Text(text=title)
            },
            text = { Text(text = message) },
            confirmButton = {
                Button(onClick = {
                    acceptButton()
                }) {
                    Text("Oк")
                }
            }
        )
    }
}
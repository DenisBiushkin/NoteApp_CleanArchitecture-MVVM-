package com.example.noteapp_cleanarchitect_mvvm.presentation.addNote_feature

sealed class AddNoteEvent {
    data class EnteredTitle(val title: String):AddNoteEvent()
    data class ChangeTitleVisibility(val visibility: Boolean):AddNoteEvent()
    data class EnteredDescription(val description: String):AddNoteEvent()
    data class ChangeDescriptionVisibility(val visibility: Boolean):AddNoteEvent()

    object SaveNote:AddNoteEvent()

}
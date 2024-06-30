package com.example.noteapp_cleanarchitect_mvvm.presentation.addNote_feature.util

import androidx.compose.ui.focus.FocusState
import com.example.noteapp_cleanarchitect_mvvm.presentation.util.ChoiceTypeDatePicker

sealed class AddNoteEvent {
    data class EnteredTitle(val title: String): AddNoteEvent()
    data class ChangeTitleVisibility(val visibility: FocusState): AddNoteEvent()
    data class EnteredDescription(val description: String): AddNoteEvent()
    data class ChangeDescriptionVisibility(val visibility: FocusState): AddNoteEvent()

    class ChoiseDate(val choiceTypeDatePicker: ChoiceTypeDatePicker) : AddNoteEvent()
    class ChoiseStartTime(val choiceTypeDatePicker: ChoiceTypeDatePicker) : AddNoteEvent()
    class ChoiseFinishTime(val choiceTypeDatePicker: ChoiceTypeDatePicker) : AddNoteEvent()
    object SaveNote: AddNoteEvent()
    object ChangeDialogMessageVisibiltity:AddNoteEvent()
    object ChangeNavigateState:AddNoteEvent()

}
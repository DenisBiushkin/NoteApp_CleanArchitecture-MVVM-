package com.example.noteapp_cleanarchitect_mvvm.presentation.toDoNote_feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp_cleanarchitect_mvvm.domain.use_case.AddNoteUseCase
import com.example.noteapp_cleanarchitect_mvvm.domain.use_case.GetNotesByDateUseCase
import com.example.noteapp_cleanarchitect_mvvm.presentation.model.CurrentDay
import com.example.noteapp_cleanarchitect_mvvm.presentation.util.ChoiceTypeDatePicker
import com.example.noteapp_cleanarchitect_mvvm.presentation.util.NoteMainEvent
import com.example.noteapp_cleanarchitect_mvvm.presentation.util.NoteState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class ToDoListViewModel @Inject constructor(
    private val getNotesByDateUseCase: GetNotesByDateUseCase,
    private val addNoteUseCase: AddNoteUseCase
):ViewModel() {

    private var _state= MutableStateFlow(
        NoteState(
        currentDay = LocalDate.now(),
        currentDay_format = CurrentDay()
    )
    )
    val state= _state.asStateFlow()
    init {
        val date_search = LocalDate.now().atTime(0,0)
        GetNotesByDate(date_search)
        onCerrentDateChanged(date_search.toLocalDate())
    }
    fun onEvent(event: NoteMainEvent){
        when(event){
            is NoteMainEvent.AddNewNote ->{
                //перейти на экран добавления
            }
            is NoteMainEvent.DeleteNote ->{
               //удалить строку дела
            }
            is NoteMainEvent.ChoiseDate->{
                when(event.choiceTypeDatePicker){
                    is ChoiceTypeDatePicker.SelectedPicker->{
                        //открыть окно даты
                    }
                    is ChoiceTypeDatePicker.RefusedDate->{
                        //закрыть окно даты
                    }
                    is ChoiceTypeDatePicker.AcceptedDate ->{

                    }
                }
            }
        }
    }
    private fun GetNotesByDate(date_search: LocalDateTime){

        viewModelScope.launch {
            getNotesByDateUseCase.execute(date_search).collect{
                notes->
                val NotesUI=notes.map {
                    it.toNoteUI()
                }
                _state.value= NoteState(
                    notes=NotesUI,
                    currentDay = state.value.currentDay,
                    currentDay_format = state.value.currentDay_format
                )
            }
        }
    }
    private fun onCerrentDateChanged(date: LocalDate){

        val formatter = DateTimeFormatter.ofPattern("MM.dd.yyyy")
        val text = date.format(formatter)
        val russianDayOfWeek = date.dayOfWeek.getDisplayName(TextStyle.FULL, Locale("ru"))
        val currentDay_format= CurrentDay(
            date_format = text,
            dayweek = russianDayOfWeek
        )
        _state.value= NoteState(
            notes=state.value.notes,
            currentDay = date,
            currentDay_format = currentDay_format
        )
    }
    fun onDateSelected(date: LocalDate){
        onCerrentDateChanged(date)
        val date_search= date.atTime(0,0)
        GetNotesByDate(date_search=date_search)
    }

}


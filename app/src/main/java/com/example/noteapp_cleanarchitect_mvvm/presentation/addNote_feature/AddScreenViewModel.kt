package com.example.noteapp_cleanarchitect_mvvm.presentation.addNote_feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import com.example.noteapp_cleanarchitect_mvvm.domain.use_case.AddNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class AddScreenViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase
):ViewModel() {
    init {
        val listNotes = listOf(
            Note(
                name = "TEST/TEST",
                description = "Улитки — тихие и неприхотливые животные, — говорили друзья, протягивая мне контейнер с животинкой. Каждую ночь теперь просыпаюсь оттого, что моё \"тихое и неприхотливое\" перетаскивает мисочку с водой на другой конец террариума и смачно бросает её в землю. Перестановку устраивает каждую ночь, чтоб её, а мне кроме моей комнаты держать её негде.",
                date_start= LocalDateTime.of(2024, 6, 29,9,0),
                date_finish = LocalDateTime.of(2024, 6, 29,10,0),
                color = 12
            ),
            Note(
                name = "Улитки",
                description = "Улитки — тихие и неприхотливые животные, — говорили друзья, протягивая мне контейнер с животинкой. Каждую ночь теперь просыпаюсь оттого, что моё \"тихое и неприхотливое\" перетаскивает мисочку с водой на другой конец террариума и смачно бросает её в землю. Перестановку устраивает каждую ночь, чтоб её, а мне кроме моей комнаты держать её негде.",
                date_start= LocalDateTime.of(2024, 6, 29,11,0),
                date_finish = LocalDateTime.of(2024, 6, 29,15,0),
                color = 12
            ),
        )
        listNotes.forEach {
            addNote(it)
        }
    }
    private fun addNote(note: Note){
        viewModelScope.launch {
            addNoteUseCase.execute(note=note)
        }
    }
}
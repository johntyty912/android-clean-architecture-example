package com.johnlai.androidcleanarchitecturesample.features.note.presentation.notes

import com.johnlai.androidcleanarchitecturesample.features.note.domain.model.Note
import com.johnlai.androidcleanarchitecturesample.features.note.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}
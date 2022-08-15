package com.johnlai.androidcleanarchitecturesample.features.note.presentation.notes

import com.johnlai.androidcleanarchitecturesample.features.note.domain.model.Note
import com.johnlai.androidcleanarchitecturesample.features.note.domain.util.NoteOrder
import com.johnlai.androidcleanarchitecturesample.features.note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
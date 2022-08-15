package com.johnlai.androidcleanarchitecturesample.features.note.presentation.add_edit_note

data class NoteTextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true,
)

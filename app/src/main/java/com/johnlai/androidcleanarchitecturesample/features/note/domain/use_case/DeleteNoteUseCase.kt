package com.johnlai.androidcleanarchitecturesample.features.note.domain.use_case

import com.johnlai.androidcleanarchitecturesample.features.note.domain.model.Note
import com.johnlai.androidcleanarchitecturesample.features.note.domain.repository.NoteRepository

class DeleteNoteUseCase(private val repository: NoteRepository) {

    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}
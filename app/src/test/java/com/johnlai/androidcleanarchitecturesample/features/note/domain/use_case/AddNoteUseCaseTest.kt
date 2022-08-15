package com.johnlai.androidcleanarchitecturesample.features.note.domain.use_case

import com.johnlai.androidcleanarchitecturesample.features.note.data.repository.FakeNoteRepository
import com.johnlai.androidcleanarchitecturesample.features.note.domain.model.InvalidNoteException
import com.johnlai.androidcleanarchitecturesample.features.note.domain.model.Note
import com.johnlai.androidcleanarchitecturesample.features.note.domain.repository.NoteRepository
import io.mockk.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

val fakeNote = Note(
    title = "title",
    content = "content",
    timestamp = System.currentTimeMillis(),
    color = 1
)

class AddNoteUseCaseTest{

    private lateinit var addNote: AddNoteUseCase
    private lateinit var mockNoteRepository: NoteRepository

    @Before
    fun setUp() {
        mockNoteRepository = mockk(relaxed = true)
        addNote = AddNoteUseCase(mockNoteRepository)
    }

    @Test
    fun `Should call noteRepository's insertNote when addNote`() = runBlocking {
        coEvery { mockNoteRepository.insertNote(any()) } just runs
        addNote(fakeNote)
        coVerify(exactly = 1) { mockNoteRepository.insertNote(any()) }
    }

    @Test
    fun `Should throws InvalidNoteException when the title is blank`() {
        val noteWithBlankTitle = fakeNote.copy(title = "")
        coEvery { mockNoteRepository.insertNote(any()) } just runs
        assertThrows(InvalidNoteException::class.java) {
            runBlocking { addNote(noteWithBlankTitle) }
        }
    }

    @Test
    fun `Should throws InvalidNoteException when the content is blank`() {
        val noteWithBlankTitle = fakeNote.copy(content = "")
        coEvery { mockNoteRepository.insertNote(any()) } just runs
        assertThrows(InvalidNoteException::class.java) {
            runBlocking { addNote(noteWithBlankTitle) }
        }
    }
}
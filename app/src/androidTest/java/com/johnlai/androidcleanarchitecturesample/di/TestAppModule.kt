package com.johnlai.androidcleanarchitecturesample.di

import android.app.Application
import androidx.room.Room
import com.johnlai.androidcleanarchitecturesample.features.note.data.data_source.NoteDatabase
import com.johnlai.androidcleanarchitecturesample.features.note.data.repository.NoteRepositoryImpl
import com.johnlai.androidcleanarchitecturesample.features.note.domain.repository.NoteRepository
import com.johnlai.androidcleanarchitecturesample.features.note.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.inMemoryDatabaseBuilder(
            app,
            NoteDatabase::class.java,
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotesUseCase(repository),
            deleteNote = DeleteNoteUseCase(repository),
            addNote = AddNoteUseCase(repository),
            getNote = GetNoteUseCase(repository)
        )
    }
}
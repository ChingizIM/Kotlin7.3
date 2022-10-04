package com.example.kotlin71.domain.repository

import androidx.lifecycle.LiveData
import com.example.kotlin71.domain.model.Note
import kotlinx.coroutines.flow.Flow


interface NoteRepository {

    fun createNote(note: Note) : Flow<Unit>
    fun createNote(note: Note) : Flow<Unit>

    fun editNote(note: Note) : Flow<Unit>

    fun deleteNote(note: Note) : Flow<Unit>

    fun getAllNotes() : Flow< List<Note>>

}
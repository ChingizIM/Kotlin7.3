package com.example.kotlin71.domain.repository

import com.example.kotlin71.domain.model.Note
import com.example.kotlin71.domain.utils.Resource
import kotlinx.coroutines.flow.Flow


interface NoteRepository {

    fun createNote(note: Note) : Flow<Resource<Unit>>

    fun editNote(note: Note) : Flow<Resource<Unit>>

    fun deleteNote(note: Note) : Flow<Resource<Unit>>

    fun getAllNotes() : Flow<Resource<List<Note>>>

}
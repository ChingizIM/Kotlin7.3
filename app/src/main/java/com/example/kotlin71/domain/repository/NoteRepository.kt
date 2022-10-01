package com.example.kotlin71.domain.repository

import com.example.kotlin71.domain.model.Note


interface NoteRepository {

    fun createNote(note: Note)

    fun editNote(note: Note)

    fun deleteNote(note: Note)

    fun getAllNotes()

}
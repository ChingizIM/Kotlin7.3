package com.example.kotlin71.data.repository


import com.example.kotlin71.App
import com.example.kotlin71.data.mapper.noteToNoteEntity
import com.example.kotlin71.domain.model.Note
import com.example.kotlin71.domain.repository.NoteRepository

class NoteRepositoryImpl: NoteRepository {

    private val noteDao = App.roomNoteDatabase.noteDao()

    override fun createNote(note: Note) {
       noteDao.createNote(note.noteToNoteEntity())
    }

    override fun editNote(note: Note) {
        noteDao.editNote(note.noteToNoteEntity())
    }

    override fun deleteNote(note: Note) {
       noteDao.deleteNote(note.noteToNoteEntity())
    }

    override fun getAllNotes() {
        noteDao.getAllNotes()
    }
}
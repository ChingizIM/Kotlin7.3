package com.example.kotlin71.domain.usecase

import com.example.kotlin71.domain.model.Note
import com.example.kotlin71.domain.repository.NoteRepository

class CreateNoteUseCase(
    private val noteRepository: NoteRepository
) {

    fun createNote(note: Note) = noteRepository.createNote(note)
    
}
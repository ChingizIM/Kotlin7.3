package com.example.kotlin71.domain.usecase

import com.example.kotlin71.domain.model.Note
import com.example.kotlin71.domain.repository.NoteRepository
import javax.inject.Inject

class EditNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {

    fun editNote(note: Note) = noteRepository.editNote(note)

}
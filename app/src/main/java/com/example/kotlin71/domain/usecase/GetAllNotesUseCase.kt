package com.example.kotlin71.domain.usecase

import com.example.kotlin71.domain.repository.NoteRepository
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {

    fun getAllNotes() = noteRepository.getAllNotes()

}
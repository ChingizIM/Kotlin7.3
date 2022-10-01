package com.example.kotlin71.data.mapper

import com.example.kotlin71.data.model.NoteEntity
import com.example.kotlin71.domain.model.Note

fun Note.noteToNoteEntity() = NoteEntity(
    id = id,
    title = title,
    text = text
)

fun NoteEntity.noteEntityToNote() = Note(
    id = id,
    title = title,
    text = text
)
package com.example.kotlin71.data.repository



import com.example.kotlin71.data.localdb.NoteDao
import com.example.kotlin71.data.mapper.noteEntityToNote
import com.example.kotlin71.data.mapper.noteToNoteEntity
import com.example.kotlin71.domain.model.Note
import com.example.kotlin71.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
): NoteRepository {


    override fun createNote(note: Note):Flow<Unit> {
return flow {
    noteDao.createNote(note.noteToNoteEntity())
}
    }

    override fun editNote(note: Note):Flow<Unit> = flow {
            noteDao.editNote(note.noteToNoteEntity())
        }

    override fun deleteNote(note: Note) : Flow<Unit> = flow {
            noteDao.deleteNote(note.noteToNoteEntity())
        }

    override fun getAllNotes(): Flow<List<Note>> = flow {
        noteDao.getAllNotes().map { it.noteEntityToNote() }

    }
}
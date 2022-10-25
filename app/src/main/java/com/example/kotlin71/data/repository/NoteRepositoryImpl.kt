package com.example.kotlin71.data.repository


import com.example.kotlin71.data.localdb.NoteDao
import com.example.kotlin71.data.mapper.noteEntityToNote
import com.example.kotlin71.data.mapper.noteToNoteEntity
import com.example.kotlin71.domain.model.Note
import com.example.kotlin71.domain.repository.NoteRepository
import com.example.kotlin71.domain.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
) : NoteRepository {

    override fun createNote(note: Note): Flow<Resource<Unit>> = flow {
        delay(2000)
        emit(Resource.Loading())
        try {
            val data = noteDao.createNote(note.noteToNoteEntity())
            emit(Resource.Success(data))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage as String))
        }
    }

    override fun editNote(note: Note): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading())
        try {
            val data = noteDao.editNote(note.noteToNoteEntity())
            emit(Resource.Success(data))
        } catch (e:Exception) {
            emit(Resource.Error(e.localizedMessage as String))
        }
    }

    override fun deleteNote(note: Note): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading())
        try {
            val data = noteDao.deleteNote(note.noteToNoteEntity())
            emit(Resource.Success(data))
        } catch (e:Exception) {
            emit(Resource.Error(e.localizedMessage as String))
        }
    }

    override fun getAllNotes(): Flow<Resource<List<Note>>> = flow {
        emit(Resource.Loading())
        try {
            val data = noteDao.getAllNotes().map { it.noteEntityToNote() }
            emit(Resource.Success(data))
        } catch (e:Exception) {
            emit(Resource.Error(e.localizedMessage as String))
        }

    }
}
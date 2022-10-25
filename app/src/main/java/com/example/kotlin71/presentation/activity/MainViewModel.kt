package com.example.kotlin71.presentation.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin71.domain.model.Note
import com.example.kotlin71.domain.usecase.CreateNoteUseCase
import com.example.kotlin71.domain.usecase.DeleteNoteUseCase
import com.example.kotlin71.domain.usecase.EditNoteUseCase
import com.example.kotlin71.domain.usecase.GetAllNotesUseCase
import com.example.kotlin71.domain.utils.Resource
import com.example.kotlin71.presentation.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val CreateNoteUseCase: CreateNoteUseCase,
    private val editNoteUseCase: EditNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase

) : ViewModel() {

    private val _getAllNotesState = MutableStateFlow<UIState<List<Note>>>(UIState.Loading())
    val getAllNotesState = _getAllNotesState.asStateFlow()

    private val _createNoteState = MutableStateFlow<UIState<Unit>>(UIState.Loading())
    val createNoteState = _createNoteState.asStateFlow()

    private val _editNoteState = MutableStateFlow<UIState<Unit>>(UIState.Loading())
    val editNoteState = _editNoteState.asStateFlow()

    private val _deleteNoteState = MutableStateFlow<UIState<Unit>>(UIState.Loading())
    val deleteNoteState = _deleteNoteState.asStateFlow()

    fun getAllNotes() {
        viewModelScope.launch {
            getAllNotesUseCase.getAllNotes().collect {
                when (it) {
                    is Resource.Loading -> {
                        _getAllNotesState.value = UIState.Loading()
                    }
                    is Resource.Error -> {
                        _getAllNotesState.value = UIState.Error(it.message ?: "Something went wrong")
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            _getAllNotesState.value = UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }
    fun createNote(note: Note){
        viewModelScope.launch {
            CreateNoteUseCase.createNote(note).collect{
                when(it){
                    is Resource.Loading->{
                        _createNoteState.value=UIState.Loading()
                    }
                    is Resource.Error->{
                        _createNoteState.value=
                            UIState.Error(it.message ?: "Something went wrong")
                    }
                    is Resource.Success->{
                        if (it.data != null){
                            _createNoteState.value=UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }
    fun editNote(note: Note) {
        viewModelScope.launch {
            editNoteUseCase.editNote(note).collect {
                when (it) {
                    is Resource.Loading -> {
                        _editNoteState.value = UIState.Loading()
                    }
                    is Resource.Error -> {
                        _editNoteState.value = UIState.Error(it.message ?: "Something went wrong")
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            _editNoteState.value = UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }
    fun deleteNote(note: Note) {
        viewModelScope.launch {
            deleteNoteUseCase.deleteNote(note).collect {
                when (it) {
                    is Resource.Loading -> {
                        _deleteNoteState.value = UIState.Loading()
                    }
                    is Resource.Error -> {
                        _deleteNoteState.value = UIState.Error(it.message ?: "Something went wrong")
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            _deleteNoteState.value = UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }
}
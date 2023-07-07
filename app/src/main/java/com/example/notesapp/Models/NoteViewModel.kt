package com.example.notesapp.Models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.notesapp.NotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.security.Provider

class NoteViewModel(private val repo:NotesRepository): ViewModel() {
    fun getAllNotes():LiveData<List<Note>>
    {
        return repo.allNotes()
    }

    fun insertNote(note:Note)
    {
        viewModelScope.launch{
            Dispatchers.IO
             repo.inserts(note)
        }
    }
}
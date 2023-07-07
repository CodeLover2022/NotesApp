package com.example.notesapp

import androidx.lifecycle.LiveData
import com.example.notesapp.Database.NoteDao
import com.example.notesapp.Models.Note

class NotesRepository(val noteDao: NoteDao) {


    fun allNotes():LiveData<List<Note>>
    {
        return noteDao.getnotes()
    }
    suspend fun inserts(note:Note)
    {
        noteDao.insert(note)
    }

}
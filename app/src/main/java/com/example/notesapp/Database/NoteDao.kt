package com.example.notesapp.Database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notesapp.Models.Note

@Dao
interface NoteDao {
    @Insert
     suspend fun insert(note: Note)

//    @Delete
//    suspend fun delete(note:Note)

//@Query("update notes_table set title= :title,note= :note where id= :id")

//    @Update
//    suspend fun update(id:Int,title:String,note:String)

    @Query("Select * from notes_table order by id ASC")
    fun getnotes():LiveData<List<Note>>
}
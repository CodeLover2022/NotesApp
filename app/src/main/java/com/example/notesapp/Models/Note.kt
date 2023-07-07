package com.example.notesapp.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="notes_table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
   val title:String,
   val note:String,
   val date:String
)

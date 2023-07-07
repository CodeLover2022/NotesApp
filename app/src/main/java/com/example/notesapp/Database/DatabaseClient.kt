package com.example.notesapp.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notesapp.Models.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class DatabaseClient:RoomDatabase() {
    abstract fun getNotesDao():NoteDao

    //singelton pattern
    companion object{
        @Volatile

        private var instance:DatabaseClient? =null
            fun getDatabase(context: Context): DatabaseClient {
                synchronized(this)
                {if (instance == null) {
                    instance =
                        Room.databaseBuilder(context, DatabaseClient::class.java, "note_data")
                            .build()
                }
                return instance!!
            }
        }
    }
}
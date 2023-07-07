package com.example.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp.Database.DatabaseClient
import com.example.notesapp.Models.Note
import com.example.notesapp.Models.NoteViewModel
import com.example.notesapp.Models.NoteViewModelFactory
import com.example.notesapp.databinding.ActivityAddNoteBinding
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class AddNote : AppCompatActivity() {
    lateinit var binding:ActivityAddNoteBinding
    lateinit var viewmodel:NoteViewModel
    lateinit var calendar: Calendar
    lateinit var dateForm:DateFormat
 lateinit var date:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
     setContentView(binding.root)
        val text=binding.etNote.text.toString()
        val title=binding.etTitle.text.toString()
        calendar=Calendar.getInstance()
        dateForm= SimpleDateFormat("MM/dd/yyyy");
        date = dateForm.format(calendar.getTime());

        val dao= DatabaseClient.getDatabase(this).getNotesDao()
        val repository=NotesRepository(dao)
        viewmodel= ViewModelProvider(this,
            NoteViewModelFactory(repository)
        ).get(NoteViewModel::class.java)
        binding.imgCheck.setOnClickListener {
            viewmodel.insertNote(Note(0, title, text, date))
        }
        binding.imgBackArrow.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
}
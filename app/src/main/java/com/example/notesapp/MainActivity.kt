package com.example.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Note
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.notesapp.Adapter.NotesAdapter
import com.example.notesapp.Database.DatabaseClient
import com.example.notesapp.Models.NoteViewModel
import com.example.notesapp.Models.NoteViewModelFactory
import com.example.notesapp.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope

class MainActivity : AppCompatActivity(),NotesAdapter.NotesitemClickListener {
    private lateinit var binding:ActivityMainBinding
    private lateinit var databse:DatabaseClient
    lateinit var viewModel:NoteViewModel
    lateinit var notesAdapter: NotesAdapter
    lateinit var selectedNote:Note
    lateinit var arr:ArrayList<Note>
    lateinit var mListener:NotesAdapter.NotesitemClickListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
         val dao=DatabaseClient.getDatabase(this).getNotesDao()
        val repository=NotesRepository(dao)
        viewModel=ViewModelProvider(this,
        NoteViewModelFactory(repository)).get(NoteViewModel::class.java)
        viewModel.getAllNotes().observe(this,{
            notesAdapter= NotesAdapter(this,it,mListener)
            binding.recyclerView.adapter=notesAdapter
            binding.recyclerView.layoutManager=StaggeredGridLayoutManager(2,LinearLayout.VERTICAL)
        })

    }
    private fun initUI()
    {
        binding.fbAddNote.setOnClickListener {
            val intent= Intent(this,AddNote::class.java)
            startActivity(intent)
            finish()
        }
    }





    override fun onLongitemClicked(note: com.example.notesapp.Models.Note, cardView: CardView) {
        TODO("Not yet implemented")
    }
}